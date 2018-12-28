/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: H:\\hiva\\YYDRobotExpression2\\app\\src\\main\\aidl\\com\\yongyida\\robot\\expression\\ExpressionControl.aidl
 */
package com.yongyida.robot.expression;
public interface ExpressionControl extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements com.yongyida.robot.expression.ExpressionControl
    {
        private static final java.lang.String DESCRIPTOR = "com.yongyida.robot.expression.ExpressionControl";
        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        /**
         * Cast an IBinder object into an com.yongyida.robot.expression.ExpressionControl interface,
         * generating a proxy if needed.
         */
        public static com.yongyida.robot.expression.ExpressionControl asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin!=null)&&(iin instanceof com.yongyida.robot.expression.ExpressionControl))) {
                return ((com.yongyida.robot.expression.ExpressionControl)iin);
            }
            return new com.yongyida.robot.expression.ExpressionControl.Stub.Proxy(obj);
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
                case TRANSACTION_startExpression:
                {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    this.startExpression(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_startExpressionFull:
                {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    java.lang.String _arg1;
                    _arg1 = data.readString();
                    int _arg2;
                    _arg2 = data.readInt();
                    java.lang.String _arg3;
                    _arg3 = data.readString();
                    java.lang.String _arg4;
                    _arg4 = data.readString();
                    com.yongyida.robot.expression.OnCompleteListener _arg5;
                    _arg5 = com.yongyida.robot.expression.OnCompleteListener.Stub.asInterface(data.readStrongBinder());
                    this.startExpression(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_stopExpression:
                {
                    data.enforceInterface(DESCRIPTOR);
                    this.stopExpression();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getExpressionSize:
                {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getExpressionSize();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getShowIndex:
                {
                    data.enforceInterface(DESCRIPTOR);
                    int _result = this.getShowIndex();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_setShowIndex:
                {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    int _result = this.setShowIndex(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_getShowExpressions:
                {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<java.lang.String> _result = this.getShowExpressions();
                    reply.writeNoException();
                    reply.writeStringList(_result);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }
        private static class Proxy implements com.yongyida.robot.expression.ExpressionControl
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
            /**
             * 开始表情(简易)
             * */
            @Override public void startExpression(java.lang.String expression) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(expression);
                    mRemote.transact(Stub.TRANSACTION_startExpression, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            /**
             * 开始表情(复杂)
             * */
            @Override
            public void startExpression(java.lang.String expression, java.lang.String data, int times, java.lang.String nextExpression, java.lang.String nextData, com.yongyida.robot.expression.OnCompleteListener onCompleteListener) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(expression);
                    _data.writeString(data);
                    _data.writeInt(times);
                    _data.writeString(nextExpression);
                    _data.writeString(nextData);
                    _data.writeStrongBinder((((onCompleteListener!=null))?(onCompleteListener.asBinder()):(null)));
                    mRemote.transact(Stub.TRANSACTION_startExpressionFull, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            /**
             * 结束表情
             * */
            @Override public void stopExpression() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_stopExpression, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
            @Override public int getExpressionSize() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getExpressionSize, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public int getShowIndex() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getShowIndex, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            @Override public int setShowIndex(int showIndex) throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(showIndex);
                    mRemote.transact(Stub.TRANSACTION_setShowIndex, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
            /**
             * 当前表情的类型
             * */
            @Override public java.util.List<java.lang.String> getShowExpressions() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<java.lang.String> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getShowExpressions, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createStringArrayList();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }
        static final int TRANSACTION_startExpression = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_startExpressionFull = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_stopExpression = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_getExpressionSize = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_getShowIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_setShowIndex = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_getShowExpressions = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    }
    /**
     * 开始表情(简易)
     * */
    public void startExpression(java.lang.String expression) throws android.os.RemoteException;
    /**
     * 开始表情(复杂)
     * */
    public void startExpression(java.lang.String expression, java.lang.String data, int times, java.lang.String nextExpression, java.lang.String nextData, com.yongyida.robot.expression.OnCompleteListener onCompleteListener) throws android.os.RemoteException;
    /**
     * 结束表情
     * */
    public void stopExpression() throws android.os.RemoteException;
    public int getExpressionSize() throws android.os.RemoteException;
    public int getShowIndex() throws android.os.RemoteException;
    public int setShowIndex(int showIndex) throws android.os.RemoteException;
    /**
     * 当前表情的类型
     * */
    public java.util.List<java.lang.String> getShowExpressions() throws android.os.RemoteException;
}
