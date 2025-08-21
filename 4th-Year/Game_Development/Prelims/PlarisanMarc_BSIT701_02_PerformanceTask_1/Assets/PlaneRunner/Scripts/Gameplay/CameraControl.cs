using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Plane.Gameplay
{
    public class CameraControl : MonoBehaviour
    {
        private static CameraControl m_Current;
        public static CameraControl Current
        {
            get { return m_Current; }
        }

        private Vector3 m_InitPosition;

        private float m_ShakeTimer;
        private float m_ShakeArc;
        private float m_ShakeRadius = 1;
        [HideInInspector]
        public bool m_ShakeEnabled = true;

        private Vector3 m_LerpedPosition;
        private Quaternion m_LerpedRotation;
        [HideInInspector]
        public float m_CameraMoveLerp = 0;
        [HideInInspector]
        public int m_CameraMod = 0;
        Vector3 m_CamOffset = Vector3.zero;

        float startZ;
        // Start is called before the first frame update

        void Awake()
        {
            m_Current = this;
        }



        void Start()
        {
            m_LerpedPosition = transform.position;
            m_LerpedRotation = transform.rotation;

            m_ShakeEnabled = true;

            //Vector3 camPos = new Vector3(0, 3.5f, -30f);
            //m_CamOffset = camPos;
            //GetComponent<Camera>().fieldOfView = 70;

            //transform.position =  camPos;

            //transform.rotation = Quaternion.Euler(20, 0, 0);
        }

        void Update()
        {
            m_ShakeTimer -= Time.deltaTime;
            //ShakeArc += 100 * Time.deltaTime;

            if (m_ShakeTimer <= 0)
                m_ShakeTimer = 0;
        }

        // Update is called once per frame
        void LateUpdate()
        {
            Vector3 finalPosition = Vector3.zero;
            Quaternion finalRotation = Quaternion.identity;

            Vector3 ShakeOffset = Vector3.zero;
            float shakeSin = Mathf.Cos(30 * Time.time) * Mathf.Clamp(m_ShakeTimer, 0, 0.5f);
            float shakeCos = Mathf.Sin(50 * Time.time) * Mathf.Clamp(m_ShakeTimer, 0, 0.5f);
            ShakeOffset = new Vector3(m_ShakeRadius * shakeCos, 0, m_ShakeRadius * shakeSin);




            //if (GameControl.m_Current.m_GameState == GameControl.State_Start)
            //{
            //    m_CameraMoveLerp += 0.5f * Time.deltaTime;
            //    m_CameraMoveLerp = Mathf.Clamp(m_CameraMoveLerp, 0, 1);
            //    Vector3 camPos = new Vector3(0, 3.5f, -20f+ m_CameraMoveLerp*10);
            //    m_CamOffset = Vector3.Lerp(m_CamOffset, camPos, m_CameraMoveLerp);
            //    GetComponent<Camera>().fieldOfView = Mathf.Lerp(GetComponent<Camera>().fieldOfView, 70, 5 * Time.deltaTime);

            //    transform.position = PlayerCar.m_Current.transform.position + m_CamOffset + ShakeOffset;
            //}
            //if (GameControl.m_Current.m_GameState == GameControl.State_Win)
            //{
                //print("win");
                //m_CameraMoveLerp += 0.2f * Time.deltaTime;
                //m_CameraMoveLerp = Mathf.Clamp(m_CameraMoveLerp, 0, 1);
                //Vector3 camPos = new Vector3(0, 3.5f, -6f);
                //m_CamOffset = Vector3.Lerp(camPos, new Vector3(0, 5.5f, -20f), m_CameraMoveLerp);
                //GetComponent<Camera>().fieldOfView = Mathf.Lerp(GetComponent<Camera>().fieldOfView, 50, 1 * Time.deltaTime);

                //transform.position += 30*Time.deltaTime * Vector3.forward;

                //Vector3 camPos = EnemyCar.m_Current.m_WreckObject.transform.position+ new Vector3(0, 3.5f, -12f);
                //transform.position = Vector3.Lerp(transform.position, camPos, .04f);
            //}
            //else
            //{
                //if (m_CameraMod == 1)
                //{
                //    Vector3 camPos = new Vector3(0, 2.5f, -6.5f);
                //    m_CamOffset = Vector3.Lerp(m_CamOffset, camPos, 5 * Time.deltaTime);
                //    transform.rotation = Quaternion.Lerp(transform.rotation, Quaternion.Euler(11, 0, 0), 40 * Time.deltaTime);
                //    GetComponent<Camera>().fieldOfView = Mathf.Lerp(GetComponent<Camera>().fieldOfView, 60, 5 * Time.deltaTime);
                //}
                //else
                //{
                //    Vector3 camPos = new Vector3(0, 3.0f, -8.5f);
                //    //camPos.x = -0.8f*transform.position.x;
                //    m_CamOffset = Vector3.Lerp(m_CamOffset, camPos, 5 * Time.deltaTime);
                //    transform.rotation = Quaternion.Lerp(transform.rotation, Quaternion.Euler(5, 0, 0), 40 * Time.deltaTime);
                //    GetComponent<Camera>().fieldOfView = Mathf.Lerp(GetComponent<Camera>().fieldOfView, 80, 5 * Time.deltaTime);
                //}

               
            //}

            Vector3 speedShake = new Vector3(0.2f * Mathf.Cos(10 * Time.time), 0.1f * Mathf.Sin(16 * Time.time), 0);
            if (!m_ShakeEnabled) 
            {
                speedShake = Vector3.zero;
            }
            Vector3 camPos = new Vector3(0, 20, -30);
            camPos.x += .6f*PlayerPlane.m_Main.transform.position.x;
            camPos.y += .3f * PlayerPlane.m_Main.transform.position.y;
            transform.position = camPos + ShakeOffset + speedShake;
        }

        public void StartShake(float t, float r)
        {
            if (m_ShakeTimer == 0 || m_ShakeRadius < r)
                m_ShakeRadius = r;

            m_ShakeTimer = t;
        }

        public Ray GetRay(Vector3 screenPosition)
        {
            Ray outputRay;
            outputRay = GetComponent<Camera>().ScreenPointToRay(screenPosition);
            return outputRay;
        }

        public Vector3 WorldToScreenPoint(Vector3 WorldPos)
        {
            Vector3 pos = GetComponent<Camera>().WorldToScreenPoint(WorldPos);
            pos.x = pos.x / Screen.width;
            pos.y = pos.y / Screen.height;

            return pos;
        }

        public Vector3 ScreenToWorldPoint(Vector3 ScreenPos)
        {
            Ray ray = GetComponent<Camera>().ScreenPointToRay(ScreenPos);
            Vector3 point = ray.origin;
            point.z = 0;

            return point;
        }


    }
}
