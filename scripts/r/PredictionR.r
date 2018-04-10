args <- commandArgs(trailingOnly = TRUE)
inputFile = args[1]
outputFile = args[2]
columnsStr = args[3]
paramsStr = args[4]
logFile = args[5]
progressFile = args[6]
inputFile
outputFile
columnsStr
paramsStr
logFile
progressFile
logFrame <- data.frame(logDate=c("2018-01-01"), logText=c("START"))
##logFrame[nrow(logFrame) + 1,] = list("2018-01-01",getwd())
##logFrame[nrow(logFrame) + 1,] = list("2018-01-01",R.home())
inData = read.csv(inputFile, sep="\t")
outData = inData
outData$confidence = 1.0
outData$output = 1.0
write.table(outData, file=outputFile, append= FALSE, quote = FALSE, sep="\t",col.names = TRUE)
##logFrame[nrow(logFrame) + 1,] =  list("2018-01-01","END")
write.table(logFrame, file=logFile, append=FALSE, quote = FALSE, sep="\t",col.names = TRUE)
prodF <- factor(inData$product)
prodF
allProducts <- levels(prodF)
"allProducts"
allProducts
allProductsCount <- levels(prodF)
distProductsCount <- length(allProducts)
"distProductsCount"
distProductsCount
for (prodIter in 1:distProductsCount) {
 print("ITER")
 currProd <- allProducts[prodIter]
 print(prodIter)
 print(currProd)
 currTransactions <- inData[which(inData$product == currProd),]
 linearModel <- lm(formula = currTransactions$sale_units ~ currTransactions$yearmonth)
 print(linearModel)
 
}

