package audio.effect;
import javax.sound.sampled.*;
import java.util.Arrays;
/** A collection of static utilities related to the audio system. */
public class AudioIO {

    /**
     * Displays every audio mixer available on the current system.
     */
    public static void printAudioMixers() {
        System.out.println("Mixers:");
        Arrays.stream(AudioSystem.getMixerInfo()).forEach(e -> System.out.println("- name=\"" + e.getName() + "\" description=\"" + e.getDescription() + " by " + e.getVendor() + "\""));
    }

    /**
     * @return a Mixer.Info whose name matches the given string.
     * Example of use: getMixerInfo("Macbook default output")
     */
    public static Mixer.Info getMixerInfo(String mixerName) {
        // see how the use of streams is much more compact than for() loops!
        return Arrays.stream(AudioSystem.getMixerInfo()).filter(e -> e.getName().equalsIgnoreCase(mixerName)).findFirst().get();
    }

    /**
     * Return a line that's appropriate for recording sound from a microphone.
     * Example of use:
     * TargetDataLine line = obtainInputLine("USB Audio Device", 8000);
     *
     * @param mixerName a string that matches one of the available mixers.
     * @seeAudioSystem.getMixerInfo() which provides a list of all mixers on your system.
     */
    public static TargetDataLine obtainAudioInput(String mixerName, int sampleRate) throws LineUnavailableException {
        AudioFormat audioformat = new AudioFormat(sampleRate, 16, 1, true, true);
        if (mixerName == "Default Audio Device") {
            return AudioSystem.getTargetDataLine(audioformat);
        } else {
            Mixer.Info info = getMixerInfo(mixerName);
            return AudioSystem.getTargetDataLine(audioformat, info);
        }
    }

    /**
     * Return a line that's appropriate for playing sound to a loudspeaker.
     */
    public static SourceDataLine obtainAudioOutput(String mixerName, int sampleRate) throws LineUnavailableException {
        Mixer.Info mixerinfo = getMixerInfo(mixerName);
        AudioFormat audioformat = new AudioFormat(sampleRate, 16, 1, true, true);
        return AudioSystem.getSourceDataLine(audioformat, mixerinfo);
    }

    public static void main(String[] args) {
    }
}

