using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AudioPlayer : MonoBehaviour
{
    private AudioSource backgroundMusic, mechanicalExplosion;

    private void Start()
    {
        backgroundMusic = GameObject.Find("BackgroundMusic").GetComponent<AudioSource>();
        mechanicalExplosion = GameObject.Find("Explosion").GetComponent<AudioSource>();

        if (backgroundMusic == null)
        {
            Debug.LogError("Audio Source component for the background music is missing!");
        }
    }

    public void OnGameLose()
    {
        mechanicalExplosion.Play();
        backgroundMusic.Stop();
    }
}
