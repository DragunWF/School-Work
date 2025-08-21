using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Plane.UI
{
    public class UIControl : MonoBehaviour
    {
        private static UIControl m_Current;
        public static UIControl Current
        { get { return m_Current; } }


        public GameObject m_LoseUI;
        public GameObject m_WinUI;
        public GameObject m_InGameUI;



        [SerializeField]
        public Camera m_EventCamera;


        void Awake()
        {
            m_Current = this;
            //m_EventCamera = GameObject.FindGameObjectWithTag("MainCamera").GetComponent<Camera>();
        }

        void Start()
        {
            Canvas[] allCanvas = GetComponentsInChildren<Canvas>(true);
            foreach (Canvas c in allCanvas)
            {
                c.worldCamera = m_EventCamera;
            }

        }

        // Update is called once per frame
        void Update()
        {

        }


    }
}
