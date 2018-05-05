package com.mlasaf.common

import java.io.{FileInputStream, FileOutputStream}
import java.security.PrivateKey

import org.json4s.FileInput

object CipherUtil {

  def main(args : Array[String]) : Unit = {
    checkAndGenerateKeyPair()
    val privKey = readPrivateKey()

    System.out.println("PRIVATE KEY " + privKey)
  }
  def checkAndGenerateKeyPair() : Unit = {
    val publicFileName = "./cipher.public.key"
    val privateFileName = "./cipher.private.key"
    if (!(new java.io.File(privateFileName)).exists()) {
      val keyPair = java.security.KeyPairGenerator.getInstance("RSA").generateKeyPair()
      val publicKey = keyPair.getPublic
      val privateKey = keyPair.getPrivate
      val publicStream = new java.io.ObjectOutputStream(new FileOutputStream(publicFileName))
      publicStream.writeObject(publicKey)
      publicStream.close()
      val privateStream = new java.io.ObjectOutputStream(new FileOutputStream(privateFileName))
      privateStream.writeObject(privateKey)
      privateStream.close()
    }

  }
  def readPrivateKey() : java.security.PrivateKey = {
    val privateFileName = "./cipher.private.key"
    val publicStream = new java.io.ObjectInputStream(new FileInputStream(privateFileName))
    val privateKey = publicStream.readObject().asInstanceOf[PrivateKey]
    privateKey
  }
}
