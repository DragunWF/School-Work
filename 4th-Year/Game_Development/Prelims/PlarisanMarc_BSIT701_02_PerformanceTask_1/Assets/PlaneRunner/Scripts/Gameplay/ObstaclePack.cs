using System.Collections;
using System.Collections.Generic;
using UnityEngine;
namespace Plane.Gameplay
{
    public class ObstaclePack : MonoBehaviour
    {
        public Transform m_EndPoint;
       
        public float m_MoveSpeed = 0;
        
        // Start is called before the first frame update
        void Start()
        {
           
        }

        // Update is called once per frame
        void Update()
        {
            transform.position += GameControl.m_Current.m_GameSpeed * Time.deltaTime * Vector3.back;
            if (transform.position.z < -50)
                Destroy(gameObject);
        }

        void OnDrawGizmos()
        {

            //Gizmos.color = Color.red;
            //Gizmos.DrawWireSphere(transform.position + new Vector3(0, 0.2f, 0), 1.8f);
            //Gizmos.color = Color.white;

            //for (int i = 0; i < m_WayPoints.Length-1; i++)
            //{
            //    Gizmos.color = Color.red;
            //    Gizmos.DrawLine(m_WayPoints[i].position, m_WayPoints[i+1].position);
            //}

            //Gizmos.color = Color.white;
            //for (float i = -7.5f; i <= 7.5f; i += 5f)
            //{
            //    Gizmos.DrawLine(transform.position + new Vector3(i,0,0), transform.position + new Vector3(i, 0, m_EndPoint.localPosition.z));
            //}
        }
    }
}
