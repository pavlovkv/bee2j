package by.bsu.bee2j;

import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Random;
/**
 * Created by user on 24.04.2016.
 */
public interface  Bee2Library extends Library{
    Bee2Library INSTANCE = (Bee2Library) Native.loadLibrary("bee2", Bee2Library.class);

    public interface IRngFunction extends Callback {
        void invoke(PointerByReference buf, int count, PointerByReference stack);
    }

    public class RngFunc implements IRngFunction{

        public void invoke(PointerByReference buf, int count, PointerByReference stack) {


            byte[] random = new byte[count];
            new Random(System.currentTimeMillis()).nextBytes(random);
            buf.getPointer().write(0, random, 0, count);

        }
    }
    Pointer beltGetH();
    int bignStdParams(BignParams bignParams, String name);
    int bignValParams(BignParams bignParams);
    int bignValPubkey(BignParams bignParams, byte[] pubKey);
    int bignGenKeypair(byte[] privKey, byte[] pubKey, BignParams bignParams,
                       IRngFunction rng, Pointer rng_state);
    int beltECBEncr(byte[] dest, byte[] src, int count,
                    byte[] theta, int len);

    int beltECBDecr(byte[] dest, byte[] src, int count,
                    byte[] theta, int len);
    int beltHash(byte[] hash, byte[] src, int count);

    int bignOidToDER(byte[] oid_der, IntByReference oid_len, String oid);
    int bignSign(
            byte[] sig,					/*!< [out] подпись */
            Pointer params,	/*!< [in] долговременные параметры */
            byte[] oid_der,			/*!< [in] идентификатор хэш-алгоритма */
            int oid_len,
            byte[] hash,			/*!< [in] хэш-значение */
            byte[] privkey,		/*!< [in] личный ключ */
            IRngFunction rng,					/*!< [in] генератор случайных чисел */
            Pointer rng_state);
    int bignVerify(
            Pointer params,	/*!< [in] долговременные параметры */
            byte[] hash,			/*!< [in] хэш-значение */
            byte[] oid_der,			/*!< [in] идентификатор хэш-алгоритма */
            int oid_len,
            byte[] sig,			/*!< [in] подпись */
            byte[] pubkey			/*!< [in] открытый ключ */
    );

    int bignCalcPubkey(
            byte[] pubkey,				/*!< [out] открытый ключ */
            BignParams params,	/*!< [in] долговременные параметры */
            byte[] privkey		/*!< [in] личный ключ */
    );
    int bignKeyWrap(
            byte[] token,					/*!< [out] токен ключа */
            BignParams params,		/*!< [in] долговременные параметры */
            byte[] key,				/*!< [in] транспортируемый ключ */
            int len,						/*!< [in] длина ключа в октетах */
            byte[] header,			/*!< [in] заголовок ключа [16]*/
            byte[] pubkey,			/*!< [in] открытый ключ получателя */
            IRngFunction rng,						/*!< [in] генератор случайных чисел */
            Pointer rng_state					/*!< [in/out] состояние генератора */
    );

    int bignKeyUnwrap(
            byte[] key,						/*!< [out] ключ */
            BignParams params,		/*!< [in] долговременные параметры */
            byte[] token,				/*!< [in] токен ключа */
            int len,						/*!< [in] длина токена в октетах */
            byte[] header,			/*!< [in] заголовок ключа [16]*/
            byte[] privkey);			/*!< [in] личный ключ получателя */
    int brngCTR_keep();
    void brngCTRStart(byte[] state, byte[] theta, byte[] iv);
    void brngCTRStepR(byte[] buf, int count, byte[] state);
}
