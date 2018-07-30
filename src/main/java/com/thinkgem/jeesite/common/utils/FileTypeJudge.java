package com.thinkgem.jeesite.common.utils;


import java.io.IOException;
import java.io.InputStream;

//文件类型判断类
public final class FileTypeJudge {

    /**
     * Constructor
     */
    private FileTypeJudge() {
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 得到文件头
     *
     * @param
     *
     * @return 文件头
     * @throws IOException
     */
    private static String getFileContent(InputStream is) throws IOException {

        byte[] b = new byte[28];

        InputStream inputStream = null;

        try {
            is.read(b, 0, 28);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return bytesToHexString(b);
    }

    /**
     * 判断文件类型
     *
     * @param
     *
     * @return 文件类型
     */
    public static FileType getType(InputStream is) throws IOException {

        String fileHead = getFileContent(is);
        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }
        fileHead = fileHead.toUpperCase();
        FileType[] fileTypes = FileType.values();

        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }
        return null;
    }
    /**
     * 判断是否是文件类型
     * @param type
     * @return
     */
    public static boolean isFileType(FileType type)
    {
        if (type==null)
        {
            return false;
        }
        FileType[] docs = { FileType.RTF, FileType.XML, FileType.HTML, FileType.CSS, FileType.JS, FileType.EML, FileType.DBX, FileType.PST, FileType.XLS_DOC, FileType.XLSX_DOCX, FileType.VSD,
                FileType.MDB, FileType.WPS, FileType.WPD, FileType.EPS, FileType.PDF, FileType.QDF, FileType.PWL, FileType.ZIP, FileType.RAR, FileType.JSP, FileType.JAVA, FileType.CLASS,
                FileType.JAR, FileType.MF, FileType.EXE, FileType.CHM , FileType.PSD};
        for (FileType fileType : docs) {
            if (fileType.equals(type)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是视频类型
     * @param type
     * @return
     */
    public static boolean isVideoType(FileType type)
    {
        if (type==null)
        {
            return false;
        }
        FileType[] videos = { FileType.AVI, FileType.RAM, FileType.RM, FileType.MPG, FileType.MOV, FileType.ASF, FileType.MP4, FileType.FLV, FileType.MID ,FileType.MKV};
        for (FileType fileType : videos) {
            if (fileType.equals(type)) {
               return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是种子类型
     * @param type
     * @return
     */
    public static boolean isTorrentType(FileType type)
    {
        if (type==null)
        {
            return false;
        }
        FileType[] tottents = { FileType.TORRENT };
        for (FileType fileType : tottents) {
            if (fileType.equals(type)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 判断是否是图片类型
     * @param type
     * @return
     */
    public static boolean  isImageType(FileType type)
    {
        if (type==null)
        {
            return false;
        }
        FileType[] pics = { FileType.JPEG, FileType.PNG, FileType.GIF, FileType.TIFF, FileType.BMP, FileType.DWG};
        for (FileType fileType : pics) {
            if (fileType.equals(type)) {
                return true;
            }
        }
        return false;
    }
    /**
     * 判断是否是音频类型
     * @param type
     * @return
     */
    public static boolean  isAudioType(FileType type)
    {
        if (type==null)
        {
            return false;
        }
        FileType[] pics = { FileType.MP3,  FileType.WAV,FileType.AAC, FileType.FLAC, FileType.MID};
        for (FileType fileType : pics) {
            if (fileType.equals(type)) {
                return true;
            }
        }
        return false;
    }

}

