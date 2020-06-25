package io.storj;

import io.storj.internal.Uplink;

public class Access {

    protected String serializedAccess;

    protected Access(String serializedAccess) {
        this.serializedAccess = serializedAccess;
    }

    /**
     * Serializes this {@link Access} to base58-encoded {@link String}.
     *
     * @return a {@link String} with serialized Access Grant
     * @throws StorjException in case of error
     */
    public String serialize() throws StorjException {
//        Uplink.StringResult.ByValue result = Uplink.INSTANCE.access_serialize(this.access);
//        ExceptionUtil.handleError(result.error);
//        String serializedAccess = result.string.getString(0);
//        Uplink.INSTANCE.free_string_result(result);
        return this.serializedAccess;
    }

    /**
     * Parses a base58-encoded {@link String} to an {@link Access}.
     *
     * @param serialized a base58-encoded {@link String}
     * @return the parsed {@link Access} Grant
     * @throws StorjException in case of error
     */
    public static Access parse(String serialized) throws StorjException {
        Uplink.AccessResult.ByValue result = Uplink.INSTANCE.parse_access(serialized);
        ExceptionUtil.handleError(result.error);
        Uplink.INSTANCE.free_access_result(result);
        return new Access(serialized);
    }

    protected Uplink.Access.ByReference internal() throws StorjException {
        Uplink.AccessResult.ByValue result = Uplink.INSTANCE.parse_access(this.serializedAccess);
        ExceptionUtil.handleError(result.error);
        return result.access;
    }

//    public Access share(Permission permission, SharePrefix... prefixes) throws StorjException {
//        Uplink.SharePrefix[] aa = new Uplink.SharePrefix[prefixes.length];
//        for (int i = 0; i < prefixes.length;i++) {
//            aa[i] = new Uplink.SharePrefix();
//        }
//        Uplink.Permission.ByReference permission1 = new Uplink.Permission.ByReference();
//        Uplink.SharePrefix.ByReference sharePrefix = new Uplink.SharePrefix.ByReference();
//        Uplink.AccessResult.ByValue result = Uplink.INSTANCE.access_share(this.access, permission1, sharePrefix, 0);
//        ExceptionUtil.handleError(result.error);
//        return new Access(result.access);
//    }
}