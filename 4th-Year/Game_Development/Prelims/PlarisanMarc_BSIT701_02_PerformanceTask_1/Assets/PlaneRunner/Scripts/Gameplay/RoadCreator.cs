using System.Collections;
using System.Collections.Generic;
using UnityEngine;
namespace Plane.Gameplay
{
    public class RoadCreator : MonoBehaviour
    {
        public static RoadCreator m_Current;

        public GameObject[] m_RoadPartPrefabs;
        public GameObject[] m_ObjectPackPrefabs;
        public GameObject[] m_ItemPackPrefabs;

        [HideInInspector]
        public RoadPart m_LastPart;
        [HideInInspector]
        public ObstaclePack m_LastObstacle;
        [HideInInspector]
        public List< ObstaclePack> m_Obstacles;

        [HideInInspector]
        public int ObstacleCounter = 0;
        [HideInInspector]
        public int ItemCounter = 0;

        void Awake()
        {
            m_Current = this;
        }

        void Start()
        {
            m_Obstacles = new List<ObstaclePack>();

            RoadPart last = null;
            for (int i = 0; i < 10; i++)
            {
                GameObject obj = Instantiate(m_RoadPartPrefabs[0]);
                RoadPart p = obj.GetComponent<RoadPart>();

                if (i == 0)
                {
                    obj.transform.position = Vector3.zero;
                    //PlayerCar.m_Current.m_CurrentRoadPart = p;
                }
                else
                {
                    obj.transform.position = last.EndPoint.position;
                    //obj.transform.rotation = Quaternion.Euler(0, i * 3, 0);
                }

                if (last!=null)
                {
                    last.m_NextPart = p;
                }
                last = p;
                m_LastPart = last;
            }


            int r = Random.Range(0, m_ObjectPackPrefabs.Length);
            GameObject obj1 = Instantiate(m_ObjectPackPrefabs[r]);
            obj1.transform.position = new Vector3(0, 0,500);
           m_LastObstacle = obj1.GetComponent<ObstaclePack>();

          
        }

        // Update is called once per frame
        void Update()
        {
            if (m_LastPart.transform.position.z < 200)
            {

                for (int i = 0; i < 10; i++)
                {
                    int r = Random.Range(0, m_RoadPartPrefabs.Length);
                    GameObject obj;

                    obj = Instantiate(m_RoadPartPrefabs[r]);


                    RoadPart p = obj.GetComponent<RoadPart>();
                    obj.transform.position = m_LastPart.EndPoint.position;
                    //obj.transform.rotation = m_LastPart.transform.rotation;
                    m_LastPart.m_NextPart = p;
                    m_LastPart = p;
                }
            }

            if (m_LastObstacle.transform.position.z < 200)
            {
                //Destroy(m_LastObstacle.gameObject,2);
                m_LastObstacle = null;

                int r = Random.Range(0, m_ObjectPackPrefabs.Length);

                GameObject obj1 = Instantiate(m_ObjectPackPrefabs[r], new Vector3(0, 0, 400),Quaternion.identity);
                m_LastObstacle = obj1.GetComponent<ObstaclePack>();
            }

               

        }

      

    }
}