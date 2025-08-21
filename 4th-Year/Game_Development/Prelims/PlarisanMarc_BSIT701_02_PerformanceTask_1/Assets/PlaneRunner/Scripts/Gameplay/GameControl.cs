using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Plane.UI;

namespace Plane.Gameplay
{
    public class GameControl : MonoBehaviour
    {
        public static GameControl m_Current;

        [HideInInspector]
        public int m_GameState = 0;
        public const int State_Start = 0;
        public const int State_Chase = 1;
        public const int State_Shoot = 2;
        public const int State_Win = 3;
        public const int State_Lose = 4;
        [HideInInspector]
        public float State_Timer = 0;

        public Transform m_SpeedParticle;

        public float m_GameSpeed = 100;

        private ScoringSystem scoringSystem;

        void Awake()
        {
            m_Current = this;
        }
        // Start is called before the first frame update
        void Start()
        {
            m_GameState = State_Start;

            scoringSystem = FindObjectOfType<ScoringSystem>();
            if (scoringSystem == null)
            {
                Debug.LogError("ScoringSystem not found in the scene.");
            }
        }

        // Update is called once per frame
        void Update()
        {
            State_Timer += Time.deltaTime;

        }

        public void HandleGameOver()
        {
            m_GameSpeed = 0;
            m_SpeedParticle.gameObject.SetActive(false);
            CameraControl.Current.m_ShakeEnabled = false;
            UIControl.Current.m_InGameUI.SetActive(false);
            UIControl.Current.m_LoseUI.SetActive(true);

            scoringSystem.OnGameLose();
        }

        public void HandleWin()
        {

        }


    }
}