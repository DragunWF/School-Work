using System.Collections;
using System.Collections.Generic;
using UnityEngine;
namespace Plane.Gameplay
{
    public class RoadPart : MonoBehaviour
    {
        public Transform EndPoint;

        [HideInInspector]
        public RoadPart m_NextPart;

        public float m_MoveSpeed = 0;

        // Start is called before the first frame update
        void Start()
        {

        }

        // Update is called once per frame
        void Update()
        {
            transform.position += GameControl.m_Current.m_GameSpeed * Time.deltaTime * Vector3.back;

            if (transform.position.z <  - 400)
            {
                Destroy(gameObject);
            }
        }

        void OnDrawGizmos()
        {
            //if (PlayerCar.m_Current != null)
            //{
            //    if (PlayerCar.m_Current.m_CurrentRoadPart == this)
            //    {
            //        Gizmos.color = Color.red;
            //        Gizmos.DrawLine(transform.position, transform.position+new Vector3(0,40,0));
            //    }
            //}
        }
    }
}
