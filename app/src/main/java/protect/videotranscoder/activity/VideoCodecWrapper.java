package protect.videotranscoder.activity;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

import protect.videotranscoder.media.VideoCodec;

/**
 * Wrapper class for the VideoCodec, which reports both the code
 * and a help string.
 *
 *
 *
 *  Executing command: -y -i /storage/emulated/0/Download/video.mp4 -t 325 -vcodec h264 -b:v 6865k -preset faster -s 2000x1000 -r 29.97 -acodec aac -ar 48000 -ac 2 -b:a 128k /storage/emulated/0/Movies/video.mp4
 */
public class VideoCodecWrapper
{
    final VideoCodec codec;
    final String helperText;

    VideoCodecWrapper(VideoCodec codec, String helperText)
    {
        this.codec = codec;
        this.helperText = helperText;
    }

    public String toString()
    {
        String text = codec.prettyName;
        if(helperText != null)
        {
            text += " (" + helperText + ")";
        }
        return text;
    }

    static List<VideoCodecWrapper> wrap(Context context, List<VideoCodec> items)
    {
        LinkedList<VideoCodecWrapper> wrapped = new LinkedList<>();
        for(VideoCodec codec : items)
        {
            String helperText = null;
            if(codec.helperTextId != null)
            {
                helperText = context.getResources().getString(codec.helperTextId);
            }
            wrapped.addLast(new VideoCodecWrapper(codec, helperText));
        }
        return wrapped;
    }
}
