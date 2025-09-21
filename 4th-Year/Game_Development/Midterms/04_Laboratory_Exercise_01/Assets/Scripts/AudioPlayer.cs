using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AudioPlayer : MonoBehaviour
{
    private AudioSource backgroundSource;

    #region Public Methods

    public void StopBackgroundMusic()
    {
        if (backgroundSource.isPlaying)
        {
            backgroundSource.Stop();
        }
    }

    #endregion

    #region Private Methods

    private void Awake()
    {
        backgroundSource = GetComponent<AudioSource>();
    }

    #endregion
}
