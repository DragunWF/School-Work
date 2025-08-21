using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Plane.Gameplay
{
    public class PlayerPlane : MonoBehaviour
    {
        public Vector2 m_Angle = Vector2.zero;
        public Transform m_Base;
        Vector2 m_TurnSpeed = Vector2.zero;


        public GameObject m_ExplodeParticle;



        public static PlayerPlane m_Main;

        private void Awake()
        {
            m_Main = this;
        }
        // Start is called before the first frame update
        void Start()
        {

        }

        // Update is called once per frame
        void Update()
        {
            float InputX = 0, InputY = 0;
            if (Input.GetKey(KeyCode.LeftArrow) || Input.GetKey(KeyCode.A))
            {
                InputX = -1;
            }
            else if (Input.GetKey(KeyCode.RightArrow) || Input.GetKey(KeyCode.D))
            {
                InputX = 1;
            }

            if (Input.GetKey(KeyCode.UpArrow) || Input.GetKey(KeyCode.W))
            {
                InputY = 1;
            }
            else if (Input.GetKey(KeyCode.DownArrow) || Input.GetKey(KeyCode.S))
            {
                InputY = -1;
            }

            Vector3 movement = 40 * Time.deltaTime * new Vector3(InputX, InputY, 0);

            //m_TurnSpeed.x -= 2000 * Time.deltaTime * InputX;
            //m_TurnSpeed.y = 500 * Time.deltaTime * InputY;
            //m_TurnSpeed -= 8*Time.deltaTime * m_TurnSpeed;

            //m_Angle += 10*Time.deltaTime * m_TurnSpeed;
            //m_Angle.x -= 3*Time.deltaTime * m_Angle.x;
            //m_Angle.x= Mathf.Clamp(m_Angle.x, -85, 85);
            //m_Angle.y = Mathf.Clamp(m_Angle.y, -45, 45);

            m_Angle.x = Mathf.Lerp(m_Angle.x, 60.0f * InputX, 5 * Time.deltaTime);
            m_Angle.y = Mathf.Lerp(m_Angle.y, 20.0f * InputY, 5 * Time.deltaTime);

            m_Base.localRotation = Quaternion.Euler(-1f * m_Angle.y, 0, -m_Angle.x);

            //transform.rotation = Quaternion.Euler(0, -0.8f*Time.deltaTime * m_Angle.x, 0) * transform.rotation;
            //transform.position += 25*Time.deltaTime * (transform.forward+new Vector3(0, .005f*m_TurnSpeed.y, 0));
            transform.position += movement;

            Vector3 pos = transform.position;
            pos.y = Mathf.Clamp(pos.y, 8, 30);
            pos.x = Mathf.Clamp(pos.x, -18, 18);
            pos.z = 0;
            transform.position = pos;

            //GetComponent<AudioSource>().pitch = 1 + 0.004f*Mathf.Abs(m_Angle.x);

            Collider[] hits = Physics.OverlapSphere(transform.position, 2.5f);
            foreach (Collider hit in hits)
            {
                if (hit.gameObject == gameObject)
                    continue;


                if (m_ExplodeParticle != null)
                {
                    GameObject obj = Instantiate(m_ExplodeParticle);
                    obj.transform.position = transform.position;
                }

                GameControl.m_Current.HandleGameOver();
                gameObject.SetActive(false);
                break;

            }


        }


    }
}

