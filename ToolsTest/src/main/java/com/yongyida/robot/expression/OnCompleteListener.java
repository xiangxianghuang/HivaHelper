/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: H:\\hiva\\YYDRobotExpression2\\app\\src\\main\\aidl\\com\\yongyida\\robot\\expression\\OnCompleteListener.aidl
 */
package com.yongyida.robot.expression;
public interface OnCompleteListener extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements com.yongyida.robot.expression.OnCompleteListener
    {
        private static final java.lang.String DESCRIPTOR = "com.yongyida.robot.expression.OnCompleteListener";
        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        /**
         * Cast an IBinder object into an com.yongyida.robot.expression.OnCompleteListener interface,
         * generating a proxy if needed.
         */
        public static com.yongyida.robot.expression.OnCompleteListener asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin!=null)&&(iin instanceof com.yongyida.robot.expression.OnCompleteListener))) {
                return ((com.yongyida.robot.expression.OnCompleteListener)iin);
            }
            return new com.yongyida.robot.expression.OnCompleteListener.Stub.Proxy(obj);
        }
        @Override public android.os.IBinder asBinder()
        {
            return this;
        }
        @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
        {
            switch (code)
            {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_onComplete:
                {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _arg1;
                    _arg1 = data.readInt();
                    this.onComplete(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
        private static class Proxy implements com.yongyida.robot.expression.OnCompleteListener
        {
            private android.os.IBinder mRemote;
            Proxy(android.os.IBinder remote)
            {
                mRemote = remote;
            }
            @Override public android.os.IBinder asBinder()
            {
                return mRemote;
            }
            public java.lang.String getInterfaceDescriptor()
            {
                return DESCRIPTOR;
            }
            @Override public void onComplete(java.lang.String expression, int times) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(expression);
                    _data.writeInt(times);
                    mRemote.transact(Stub.TRANSACTION_onComplete, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
        static final int TRANSACTION_onComplete = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }
    public void onComplete(java.lang.String expression, int times) throws android.os.RemoteException;
}
