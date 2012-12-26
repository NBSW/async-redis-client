package mobi.app.redis.netty.command;

import mobi.app.redis.transcoders.Transcoder;

/**
 * User: thor
 * Date: 12-12-25
 * Time: 上午10:37
 */
public class SetexCommand<T> extends BaseCommand<T> {
    public SetexCommand(Transcoder transcoder, String command, String key, int seconds, Object v) {
        this.command = command;
        setTranscoder(transcoder);
        byte[][] byteArgs = new byte[3][];
        byteArgs[0] = tu.encodeString(key);
        byteArgs[1] = tu.encodeString(String.valueOf(seconds));
        //noinspection unchecked
        byteArgs[2] = getTranscoder().encode(v);

        init(byteArgs);
    }
}
