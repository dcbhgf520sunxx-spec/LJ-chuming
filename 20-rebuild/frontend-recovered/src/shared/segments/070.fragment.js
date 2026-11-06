function HSe(e) {
  return W({ url: "/api/crm/bidding/center/my/tender/list/down/load/custom", method: "get", params: e });
}
function qSe(e) {
  return W({ url: "/api/crm/bidding/center/archives/management/list/down/load/custom", method: "get", params: e });
}
function GSe(e) {
  return W({ url: "/api/crm/winning/contract/warehousing/contract/list/down/load", method: "get", params: e });
}
const yl = { businessSummaryReport: LSe, businessSummaryDetailReport: ISe, engineerInformationReport: CSe, businessBidReport: PSe, projectInfoReport: OSe, governmentReport: kSe, platFormReport: DSe, supplierReport: xSe, businessInfoList: USe, supplierInfoList: YSe, governmentInfoList: KSe, platFormInfoList: WSe, projectInfoList: jSe, bidInfoList: FSe, specificalBidInfoList: zSe, organizeBidInfoList: BSe, myProjectList: HSe, documentInfoList: qSe, bidProjectInfoList: GSe }, QSe = yt.myProject, ZSe = yt.projectList, JSe = yt.contractLedger, XSe = yt.collectionProject, $Se = yt.scrapCollection, eve = yt.collectionLedger, tve = yt.invoiceProject, ive = yt.scrapInvoice, ave = yt.invoiceLedger, lve = yt.arrearsList, ove = yt.contractBoxPrice, nve = yt.structurePrice, sve = yt.enclosurePrice, rve = yt.auxiliaryMaterialPrice, uve = yt.auxiliaryMaterialPrice, cve = yt.machinePartPrice, dve = yt.machinePartDetail, mve = yt.collectionDetail, pve = yt.invoiceDetail, hve = yt.happenedDetail, fve = yt.transactionRecord, gve = yt.structurePrice, Eve = yt.structurePrice, yve = yt.structurePrice, Tve = yt.bridgeShipmentTracking, _ve = yt.shipmentTracking, bve = yt.shipmentTracking, Vve = yt.shipmentTracking, wve = yt.shipmentTracking, Sve = yt.collectionInfo, vve = yt.collectionInfoV2, Rve = yt.invoiceInfo, Mve = yt.invoiceInfoV2, Ave = yt.expendInfo, Nve = yt.expendInfoV2, Lve = yt.capitalInjection, Ive = yt.capitalInjectionUse, Cve = yt.creditExtension, Pve = yt.approvalManagement, Ove = yt.expendPaymentRecord, kve = yt.expendInvoiceRecord, Dve = yt.selfExpendCollectionDetail, xve = yt.selfExpendInvoiceDetail, Uve = yt.selfCollectionAndInvoiceInfo, Yve = yt.selfTotalDisburse, Kve = yt.innerCostMaterials, Wve = yt.innerCostOther, jve = yt.innerCostManage, Fve = yt.innerIncomeDetail, zve = yt.selfCostMaterials, Bve = yt.selfCostMaterials, Hve = yt.selfCostMaterials, qve = yt.selfCostMaterials, Gve = yt.selfPaymentRecord, Qve = yt.selfCostPeriod, Zve = yt.stairUnitSupplierPaymentDetail, Jve = yt.stairUnitSupplierPaymentDetail, Xve = yt.stairUnitSupplierPaymentDetail, $ve = yt.stairUnitSupplierTicketDetail, eRe = yt.secondUnitSelfCollectionDetail, tRe = yt.secondUnitSelfInvoiceDetail, iRe = yt.purchaseSupplierInvoiceDetail, aRe = yt.purchaseSupplierInvoiceDetail, lRe = yt.purchaseSupplierInvoiceDetail, oRe = yt.stairUnitSupplierSettleDetail, nRe = yt.stairUnitSupplierSettleDetail, sRe = yt.stairUnitSupplierSettleDetail, rRe = yt.stairUnitSupplierPaymentDetail, uRe = yt.secondUnitSelfPreSettleDetail, cRe = yt.selfPreSettleDetail, dRe = yt.paymentPurchaseOrderRecord, mRe = yt.paymentSubcontractRecord, pRe = yt.paymentManufShippingRecord, hRe = yt.paymentMaterialShippingRecord, fRe = yt.logisticsLedger, gRe = yt.payableSummary, ERe = yt.supplierPayableList, yRe = yt.supplierPayableLedger, TRe = yt.supplierInvoiceLedger, _Re = yt.saleOrderTracking, bRe = yt.unitListValuationDetail, VRe = yt.unitListValuationDetail, wRe = yt.unitListValuationDetail, SRe = yt.unitOrderTrackingShip, vRe = yt.unitOrderTrackingCollection, RRe = yt.unitOrderTrackingInvoice, MRe = yt.warehouseRecord, ARe = yt.industryElectricRecord, NRe = yt.civilElectricRecord, LRe = yt.waterRecord, IRe = yt.gasRecord, CRe = yt.expenseReimburseList, PRe = yt.managementSalaryList, ORe = yt.productionSalaryList, kRe = yt.propertyFeeList, DRe = yt.mainMaterialList, xRe = yt.mainMaterialList, URe = yt.manualList, YRe = yt.shippingFeeList, KRe = yt.testingFee, WRe = yt.subcontractFee, jRe = yt.projectManagementFee, FRe = yt.managementFee, zRe = yt.waterElectricFee, BRe = yt.depreciationFee, HRe = yt.fortuneReportList, qRe = yt.scrapDate, GRe = yt.scrapPurchaser, QRe = yt.totalScrapDetaile, ZRe = yt.returnLedgerList, JRe = yt.returnLedgerDetail, XRe = yt.recoveryPaymentRecord, $Re = yt.recoveryInvoiceRecord, e3e = yt.productWasteList, t3e = yt.productWasteDetail, i3e = yt.productCollectionRecord, a3e = yt.productInvoiceRecord, l3e = yt.shipmentReturnListStructure, o3e = yt.shipmentReturnListEnclosure, n3e = yt.factoryDepreciation, s3e = yt.equipmentDepreciation, r3e = yt.reimbursementFee, u3e = yt.wageCost, c3e = yt.fabricatingCostStatistics, d3e = yt.mainMaterialsStatistics, m3e = yt.auxiliaryMaterialsDirectCost, p3e = yt.auxiliaryMaterialsAmortizationCost, h3e = yt.otherSteelMaterials, f3e = yt.paintCost, g3e = yt.weldingConsumableCost, E3e = yt.productionLaborCost, y3e = yt.tempWorkAmortizationCost, T3e = yt.managerAmortizationCost, _3e = yt.transportationCost, b3e = yt.waterElectricityAmortization, V3e = yt.fabricatingCostStatisticsGasFee, w3e = yt.fabricatingCostStatisticsGasDirectCost, S3e = yt.propertyAmortization, v3e = yt.directCostReport, R3e = yt.amortizationCostReport, M3e = yt.materialConstructionSiteCostReport, A3e = yt.materialConstructionSitePaymentRecord, N3e = yt.factoryDepreciationReport, L3e = yt.equipmentDepreciationReport, I3e = yt.testingFeeReport, C3e = yt.finishedProductScrapLoss, P3e = yt.manufRepairList, O3e = yt.manufReuseList, k3e = yt.mainBusinessIncome, D3e = yt.nonMainBusinessIncome, x3e = Nl.invoiceDetail, U3e = Nl.inboundRecord, Y3e = Nl.paymentRecord, K3e = Nl.orderPaymentLedger, W3e = Nl.supplierPaymentLedger, j3e = Nl.storageDetails, F3e = Nl.newStorageDetails, z3e = Nl.purchaseDetailDimensions, B3e = Nl.purchaseDetailDimensions, H3e = Nl.newManufacturedStorageDetails, q3e = Nl.preSettlementDetail, G3e = Nl.logisticsRecord, Q3e = Nl.requisitionsDetail, Z3e = Nl.manufRequisitionsDetail, J3e = Nl.purchaseDetail, X3e = Nl.manufRequisitionsDetail, $3e = Nl.purchaseShippingList, e4e = mt.schedulingDetail, t4e = mt.productionTaskOrder, i4e = mt.productionTaskOrders, a4e = mt.assembleNestingOrder, l4e = mt.assembleProductionTaskOrder, o4e = mt.drillProductionTaskOrder, n4e = mt.drillProductionTaskOrder, s4e = mt.projectProductionPrint, r4e = mt.projectTeamGroupPrint, u4e = mt.productionDetailPrint, c4e = mt.productionDetailPrint, d4e = mt.productionReport, m4e = mt.productionReport, p4e = mt.productionReport, h4e = mt.productionReport, f4e = mt.productionStatistics, g4e = mt.productionStatisticsIn, E4e = mt.productionStatisticsUn, y4e = mt.productionStatisticsComplete, T4e = mt.productionStatistics, _4e = mt.productionStatisticsIn, b4e = mt.productionStatisticsUn, V4e = mt.productionStatisticsComplete, w4e = mt.unfinishedList, S4e = mt.enclosureProductionLine, v4e = mt.structureProductionLine, R4e = mt.structureProcess, M4e = mt.machinePartDetail, A4e = mt.machinePartList, N4e = mt.paintingList, L4e = mt.structureProjectSummary, I4e = mt.enclosureProjectSummary, C4e = mt.qhseProductionLineReport, P4e = mt.projectOverviewList, O4e = mt.mesSchedulingDataList, k4e = mt.teamWage, D4e = mt.teamWage, x4e = mt.teamWageDetail, U4e = mt.teamWageDetail, Y4e = mt.packingList, K4e = mt.bridgePackingList, W4e = mt.enclosurePackingList, j4e = mt.shipmentSummary, F4e = mt.bridgeShipmentSummary, z4e = mt.shipmentDetail, B4e = mt.cargoDayOrMonthSummary, H4e = mt.cargoDayOrMonthSummary, q4e = mt.bridgeShipmentDetail, G4e = mt.receiptStatusSummary, Q4e = mt.shippingList, Z4e = mt.mesBridgeReceiptStatusSummary, J4e = mt.mesBridgeShippingList, X4e = mt.shipmentAudit, $4e = mt.mesShipmentAuditDetail, e8e = mt.shipmentAuditOverWeight, t8e = mt.mesBridgeShipmentAudit, i8e = mt.mesBridgeShipmentAuditOverWeight, a8e = mt.logisticsSummary, l8e = mt.bridgeLogisticsSummary, o8e = mt.warehouseStateStructure, n8e = mt.warehouseStateEnclosure, s8e = mt.warehouseStateReport, r8e = mt.artifactClassList, u8e = mt.assembleClassList, c8e = mt.machinePartClassList, d8e = mt.productionKanbanList, m8e = mt.productionKanbanGroupList, p8e = mt.monthlyTaskList, h8e = mt.processList, f8e = mt.productionLineList, g8e = mt.workOrderTrackingList, E8e = mt.wipStatisticsLis, y8e = mt.processStatisticsList, T8e = mt.taskStatisticsList, _8e = mt.upsStatisticsList, b8e = mt.outBoundStatisticsList, V8e = mt.backBoundStatisticsList, w8e = mt.wagesReport, S8e = mt.factoryWorkshopReport, v8e = mt.groupsReport, R8e = mt.productionStatisticsReport, M8e = mt.taskDelayNotifyReport, A8e = mt.studSleeveStatisticsList, N8e = mt.mesProjectShipDetail, L8e = mt.mesProjectShipDetailDirect, I8e = mt.bridgeProjectShipDetail, C8e = mt.enclosureProjectShipDetail, P8e = mt.mesShipMeteDetail, O8e = mt.mesShipTaskMeteDetail, k8e = mt.mesShipInboundMeteDetail, D8e = mt.mesShipTotalMeteDetail, x8e = mt.mesShipMonthMeteDetail, U8e = mt.mesShipStockMeteDetail, Y8e = mt.mesShipPackageMeteDetail, K8e = mt.mesShipMeteDetailDirect, W8e = mt.mesShipMeteDetailDirect, j8e = mt.mesShipMeteDetailDirect, F8e = mt.mesShipMeteDetailDirect, z8e = mt.mesShipMeteDetailDirect, B8e = mt.mesShipMeteDetailDirect, H8e = mt.mesShipMeteDetailDirect, q8e = mt.mesTeamWageSummary, G8e = mt.mesTeamProduction, Q8e = mt.violationRecordReport, Z8e = mt.mesDailyStatisticsSum, J8e = mt.mesDailyStatisticsProductionDetail, X8e = mt.mesDailyStatisticsPackDetail, $8e = mt.coatingProcess, e6e = mt.paintingCraftListPrint, t6e = mt.paintingCraftListDetailPrint, i6e = mt.workReportingRecord, a6e = mt.mesPaintTechnologyStatistics, l6e = mt.mesPaintTechnologyListDetail, o6e = mt.mesPaintTechnologyRecordArtifactPrint, n6e = mt.bridgeShipMeteDetail, s6e = mt.bridgeShipTaskMeteDetail, r6e = mt.bridgeShipInboundMeteDetail, u6e = mt.bridgeShipTotalMeteDetail, c6e = mt.bridgeShipMonthMeteDetail, d6e = mt.bridgeShipStockMeteDetail, m6e = mt.mesShipTrainMeteDetail, p6e = mt.bridgeShipMeteDetailDirect, h6e = mt.bridgeShipMeteDetailDirect, f6e = mt.bridgeShipMeteDetailDirect, g6e = mt.bridgeShipMeteDetailDirect, E6e = mt.bridgeShipMeteDetailDirect, y6e = mt.bridgeShipMeteDetailDirect, T6e = mt.enclosureShipMeteDetail, _6e = mt.enclosureShipTaskMeteDetail, b6e = mt.enclosureShipInboundMeteDetail, V6e = mt.enclosureShipTotalMeteDetail, w6e = mt.enclosureShipMonthMeteDetail, S6e = mt.enclosureShipStockMeteDetail, v6e = mt.mesAuxMatDetail, R6e = mt.bridgeAuxMatDetail, M6e = mt.enclosureAuxMatDetail, A6e = mt.productSendReceiveStorage, N6e = mt.productSendReceiveStorage, L6e = mt.boxProductSendReceiveStorage, I6e = mt.boxProductSendReceiveStorage, C6e = mt.enclosureProductSendReceiveStorage, P6e = mt.productSendReceiveStorageDetail, O6e = mt.boxProductSendReceiveStorageDetail, k6e = mt.structureFinishedGoodsInventoryDetail, D6e = mt.structureFinishedGoodsInventoryDetail, x6e = mt.structureFinishedGoodsInventoryDetail, U6e = mt.structureFinishedGoodsInventoryDetail, Y6e = mt.enclosureProductSendReceiveStorageDetail, K6e = mt.mesBeginningInventoryDetail, W6e = mt.mesEndInventoryDetail, j6e = mt.mesPackageInventoryDetail, F6e = mt.mesInboundInventoryDetail, z6e = mt.sectionProductInventoryDetail, B6e = mt.sectionProductInventoryDetail, H6e = mt.sectionProductInventoryDetail, q6e = mt.sectionProductInventoryDetail, G6e = mt.mesOutboundInventoryDetail, Q6e = mt.boxBeginningInventoryDetail, Z6e = mt.boxEndInventoryDetail, J6e = mt.boxInboundInventoryDetail, X6e = mt.boxOutboundInventoryDetail, $6e = mt.enclosureBeginningInventoryDetail, eMe = mt.enclosureEndInventoryDetail, tMe = mt.enclosureInboundInventoryDetail, iMe = mt.enclosureOutboundInventoryDetail, aMe = mt.enclosureTotalBeginningInventoryDetail, lMe = mt.enclosureTotalEndInventoryDetail, oMe = mt.enclosureTotalInboundInventoryDetail, nMe = mt.enclosureTotalOutboundInventoryDetail, sMe = mt.mainMaterialTrackSummary, rMe = mt.mainMaterialTrackUseRecord, uMe = mt.mainMaterialTrackStock, cMe = mt.lossStatistics, dMe = mt.productionDetail, mMe = mt.receiveDetail, pMe = mt.shareReport, hMe = mt.workInProgressInventoryStatistics, fMe = mt.lossStatisticsV2, gMe = mt.lossStatisticsSchedulingDetail, EMe = mt.lossStatisticsReceiveDetail, yMe = mt.lossStatisticsSteelFeedingDetail, TMe = mt.lossStatisticsPartReportDetail, _Me = mt.manufacturesSalesReturnReport, bMe = mt.structureAuxiliarySalesReturnAuditReport, VMe = mt.enclosureAuxiliarySalesReturnAuditReport, wMe = mt.structureSalesReturnAuditReport, SMe = mt.enclosureSalesReturnAuditReport, vMe = mt.wasteStorageReport, RMe = mt.structureAuxiliaryWasteStorageAuditReport, MMe = mt.enclosureAuxiliaryWasteStorageAuditReport, AMe = mt.structureWasteStorageAuditReport, NMe = mt.enclosureWasteStorageAuditReport, LMe = Ti.schedulingDetail, IMe = Ti.productionTaskOrder, CMe = Ti.assembleNestingOrder, PMe = Ti.assembleProductionTaskOrder, OMe = Ti.drillProductionTaskOrder, kMe = Ti.drillProductionTaskOrder, DMe = Ti.productionReport, xMe = Ti.productionReport, UMe = Ti.productionReport, YMe = Ti.productionReport, KMe = Ti.productionStatistics, WMe = Ti.productionStatisticsIn, jMe = Ti.productionStatisticsUn, FMe = Ti.productionStatisticsComplete, zMe = Ti.productionStatistics, BMe = Ti.productionStatisticsIn, HMe = Ti.productionStatisticsUn, qMe = Ti.productionStatisticsComplete, GMe = Ti.unfinishedList, QMe = Ti.structureProductionLine, ZMe = Ti.structureProcess, JMe = Ti.machinePartDetail, XMe = Ti.machinePartList, $Me = Ti.paintingList, eAe = Ti.structureProjectSummary, tAe = Ti.enclosureProjectSummary, iAe = Ti.qhseProductionLineReport, aAe = Ti.projectOverviewList, lAe = Ti.teamWage, oAe = Ti.teamWage, nAe = Ti.teamWageDetail, sAe = Ti.teamWageDetail, rAe = Ti.packingList, uAe = Ti.shipmentSummary, cAe = Ti.shipmentDetail, dAe = Ti.receiptStatusSummary, mAe = Ti.shippingList, pAe = Ti.shipmentAudit, hAe = Ti.logisticsSummary, fAe = Ti.warehouseStateStructure, gAe = Ti.warehouseStateEnclosure, EAe = Ti.warehouseStateReport, yAe = Ti.boxClassList, TAe = Ti.elementClassList, _Ae = Ti.machinePartClassList, bAe = Ti.monthlyTaskList, VAe = Ti.processList, wAe = Ti.productionLineList, SAe = Ti.workOrderTrackingList, vAe = Ti.factoryWorkshopReport, RAe = Ti.studSleeveStatisticsList, MAe = Ti.bridgeProjectShipDetail, AAe = Ti.bridgeProjectShipDetailDirect, NAe = Ti.productSendReceiveStorage, LAe = Ti.productSendReceiveStorageDetail, IAe = Ti.structureFinishedGoodsInventoryDetail, CAe = Ti.boxSummary, PAe = Ti.cellSummary, OAe = Ti.partSummary, kAe = io.wmsRmOutboundReceipt, DAe = io.wmsRmManufOutboundReceipt, xAe = io.wmsRmInboundReceipt, UAe = io.manufRmInboundReceipt, YAe = io.wmsRmReturnReceipt, KAe = io.wmsRmRejectReceipt, WAe = io.wmsRmTransferReceipt, jAe = io.wmsRmMoveMaterialReceipt, FAe = io.wmsRmMoveMaterialDetails, zAe = io.wmsRmSupplementReceipt, BAe = io.wmsScrapSell, HAe = io.wmsRmOutboundReceiptReport, qAe = io.wmsRmReturnReceiptReport, GAe = io.wmsRmTransferReceiptReport, QAe = Ll.deliveryCargoList, ZAe = Ll.deliveryPartCargoList, JAe = Ll.deliveryReportList, XAe = Ll.deliveryOutReportList, $Ae = Ll.deliveryInstallList, eNe = Ll.installReportList, tNe = Ll.productProcessList, iNe = Ll.productEnclosureProcessList, aNe = Ll.deepenProcessList, lNe = Ll.deepenEnclosureProcessList, oNe = Ll.receivingRecord, nNe = Ll.outReceivingRecord, sNe = Ll.outsourcingReturnRecord, rNe = Ll.outsourcingReceivingRecord, uNe = Ll.laborSettingList, cNe = Ll.laborInstallList, dNe = Ll.projectInstallList, mNe = Mu.auxiliaryMaterialSummary, pNe = Mu.schedulingDetailPrint, hNe = Mu.producedDetailPrint, fNe = Mu.notProducedDetailPrint, gNe = Mu.deliveryDetailPrint, ENe = Au.schedulingWorkOrderDetail, yNe = Au.taskTrackingDetail, TNe = Au.productionStatistics, _Ne = Au.teamProduction, bNe = Au.teamProductionDetail, VNe = yl.businessSummaryReport, wNe = yl.businessSummaryDetailReport, SNe = yl.engineerInformationReport, vNe = yl.businessBidReport, RNe = yl.projectInfoReport, MNe = yl.governmentReport, ANe = yl.platFormReport, NNe = yl.supplierReport, LNe = yl.businessInfoList, INe = yl.supplierInfoList, CNe = yl.governmentInfoList, PNe = yl.platFormInfoList, ONe = yl.projectInfoList, kNe = yl.bidInfoList, DNe = yl.specificalBidInfoList, xNe = yl.organizeBidInfoList, UNe = yl.myProjectList, YNe = yl.documentInfoList, KNe = yl.bidProjectInfoList, WNe = { myProject: QSe, projectList: ZSe, contractLedger: JSe, collectionLedger: eve, collectionRecord: XSe, invoiceLedger: ave, invoiceRecord: tve, scrapInvoice: ive, scrapCollection: $Se, arrearsList: lve, totalScrapDetaile: QRe, returnLedgerList: ZRe, returnLedgerDetail: JRe, recoveryPaymentRecord: XRe, recoveryInvoiceRecord: $Re, productWasteList: e3e, productWasteDetail: t3e, productCollectionRecord: i3e, productInvoiceRecord: a3e, shipmentReturnListStructure: l3e, shipmentReturnListEnclosure: o3e, collectionInfo: Sve, collectionInfoV2: vve, invoiceInfo: Rve, invoiceInfoV2: Mve, expendInfo: Ave, expendInfoV2: Nve, capitalInjection: Lve, capitalInjectionUse: Ive, creditExtension: Cve, approvalManagement: Pve, expendPaymentRecord: Ove, expendInvoiceRecord: kve, selfExpendCollectionDetail: Dve, selfExpendInvoiceDetail: xve, selfCollectionAndInvoiceInfo: Uve, selfTotalDisburse: Yve, innerCostMaterials: Kve, innerCostOther: Wve, innerCostManage: jve, innerIncomeDetail: Fve, selfCostMaterials: zve, costLabourServices: Bve, subcontractingCost: Hve, rentalCost: qve, selfPaymentRecord: Gve, selfCostPeriod: Qve, stairUnitSupplierPaymentDetail: Zve, stairUnitSupplierPurchasePaymentDetail: Jve, stairUnitSupplierLedgerPaymentDetail: Xve, stairUnitSupplierLedgerPreSettleDetail: rRe, stairUnitSupplierTicketDetail: $ve, secondUnitSelfCollectionDetail: eRe, secondUnitSelfPreSettleDetail: uRe, selfPreSettleDetail: cRe, secondUnitSelfInvoiceDetail: tRe, purchaseSupplierInvoiceDetail: iRe, purchaseSupplierPurchaseInvoiceDetail: aRe, purchaseSupplierLedgerInvoiceDetail: lRe, stairUnitSupplierSettleDetail: oRe, stairUnitSupplierPurchaseSettleDetail: nRe, stairUnitSupplierLedgerSettleDetail: sRe, logisticsPaymentLedger: fRe, supplierPayableSummary: gRe, supplierPayableList: ERe, supplierPaymentLedger: yRe, supplierInvoiceLedger: TRe, storageDetails: j3e, newStorageDetails: F3e, newManufacturedStorageDetails: H3e, preSettlementDetail: q3e, contractBoxPrice: ove, contractStructurePrice: nve, contractEnclosurePrice: sve, contractAuxiliaryMaterialPrice: rve, contractAuxiliaryMaterialPriceEnclosure: uve, contractMachinePartPrice: cve, machinePartDetail: dve, projectCollectionDetail: mve, projectInvoiceDetail: pve, projectHappenedDetail: hve, transactionRecord: fve, saleOrderTracking: _Re, unitListValuationStructureDetail: bRe, unitListValuationEnclosureDetail: VRe, unitListValuationAuxiliaryMaterialDetail: wRe, unitOrderTrackingShip: SRe, unitOrderTrackingCollection: vRe, unitOrderTrackingInvoice: RRe, contractStructureProduct: gve, contractEnclosureProduct: Eve, contractAuxiliaryMaterialProduct: yve, contractBoxShipmentTracking: Tve, contractStructureShipmentTracking: _ve, StraighthairShipmentTracking: bve, contractEnclosureShipmentTracking: Vve, contractAuxiliaryMaterialShipmentTracking: wve, projectWarehouseRecord: MRe, industryElectricRecord: ARe, civilElectricRecord: NRe, waterRecord: LRe, gasRecord: IRe, expenseReimburseList: CRe, managementSalaryList: PRe, productionSalaryList: ORe, propertyFeeList: kRe, factoryDepreciation: n3e, equipmentDepreciation: s3e, reimbursementFee: r3e, wageCost: u3e, fabricatingCostStatistics: c3e, mainMaterialsStatistics: d3e, auxiliaryMaterialsDirectCost: m3e, auxiliaryMaterialsAmortizationCost: p3e, otherSteelMaterials: h3e, paintCost: f3e, weldingConsumableCost: g3e, productionLaborCost: E3e, tempWorkAmortizationCost: y3e, managerAmortizationCost: T3e, transportationCost: _3e, waterElectricityAmortization: b3e, fabricatingCostStatisticsGasFee: V3e, fabricatingCostStatisticsGasDirectCost: w3e, propertyAmortization: S3e, directCostReport: v3e, amortizationCostReport: R3e, materialConstructionSiteCostReport: M3e, materialConstructionSitePaymentRecord: A3e, factoryDepreciationReport: N3e, equipmentDepreciationReport: L3e, testingFeeReport: I3e, finishedProductScrapLoss: C3e, manufCostReturnRepair: P3e, manufCostReuse: O3e, mainBusinessIncome: k3e, nonMainBusinessIncome: D3e, conMainMaterialList: DRe, manualList: URe, shippingFeeList: YRe, testingFee: KRe, subcontractFee: WRe, projectManagementFee: jRe, managementFee: FRe, waterElectricFee: zRe, depreciationFee: BRe, auxiliaryMaterialList: xRe, fortuneReportList: HRe, scrapDate: qRe, scrapPurchaser: GRe, paymentPurchaseOrderRecord: dRe, paymentSubcontractRecord: mRe, paymentManufShippingRecord: pRe, paymentMaterialShippingRecord: hRe, purchaseInvoiceRecord: x3e, purchaseInboundRecord: U3e, purchasePaymentRecord: Y3e, orderPaymentLedger: K3e, scmSupplierPaymentLedger: W3e, purchaseLogisticsRecord: G3e, scmRequisitionsDetail: Q3e, scmManufRequisitionsDetail: Z3e, scmPurchaseDetail: J3e, scmManufEnclosureRequisitionsDetail: X3e, purchaseDetailDimensions: z3e, purchaseDetailDimensionsProduct: B3e, purchaseShippingList: $3e, mesSchedulingDetail: e4e, mesProductionTaskOrder: t4e, mesProductionTaskOrders: i4e, mesAssembleNestingOrder: a4e, mesAssembleProductionTaskOrder: l4e, mesNestingProductionTaskOrder: n4e, mesDrillProductionTaskOrder: o4e, mesProjectProduction: s4e, mesProjectTeamGroup: r4e, mesProductionPanel: u4e, mesProductionAccessoryPanel: c4e, mesStructureProductionReport: d4e, mesAssemblePartProductionReport: m4e, mesMachinePartProductionReport: p4e, mesEnclosureProductionReport: h4e, mesStructureProductionStatistics: f4e, mesStructureProductionStatisticsIn: g4e, mesStructureProductionStatisticsUn: E4e, mesStructureProductionStatisticsComplete: y4e, mesEnclosureProductionStatistics: T4e, mesEnclosureProductionStatisticsIn: _4e, mesEnclosureProductionStatisticsUn: b4e, mesEnclosureProductionStatisticsComplete: V4e, mesUnfinishedList: w4e, mesEnclosureProductionLine: S4e, mesStructureProductionLine: v4e, mesStructureProcess: R4e, mesMachinePartDetail: M4e, mesMachinePartList: A4e, mesPaintingList: N4e, mesStructureProjectSummary: L4e, mesEnclosureProjectSummary: I4e, mesQHSEProductionLineReport: C4e, mesProjectOverviewList: P4e, mesSchedulingDataList: O4e, mesMainMaterialTrack: sMe, mesMainMaterialTrackUseRecord: rMe, mesMainMaterialTrackStock: uMe, mesStructureTeamWage: k4e, mesEnclosureTeamWage: D4e, mesStructureTeamWageDetail: x4e, mesEnclosureTeamWageDetail: U4e, mesPackingList: Y4e, mesBridgePackingList: K4e, enclosurePackingList: W4e, mesShipmentSummary: j4e, mesBridgeShipmentSummary: F4e, mesShipmentDetail: z4e, mesMonthlyDeliverySummary: B4e, mesDailyDeliverySummary: H4e, mesBridgeShipmentDetail: q4e, mesReceiptStatusSummary: G4e, mesShippingList: Q4e, mesBridgeReceiptStatusSummary: Z4e, mesBridgeShippingList: J4e, mesShipmentAudit: X4e, mesShipmentAuditDetail: $4e, mesShipmentAuditOverWeight: e8e, mesBridgeShipmentAudit: t8e, mesBridgeShipmentAuditOverWeight: i8e, mesLogisticsSummary: a8e, mesBridgeLogisticsSummary: l8e, mesWarehouseStateStructure: o8e, mesWarehouseStateEnclosure: n8e, mesWarehouseStateReport: s8e, mesArtifactClassList: r8e, mesAssembleClassList: u8e, mesMachinePartClassList: c8e, mesProductionKanbanList: d8e, mesProductionKanbanGroupList: m8e, mesMonthlyTaskList: p8e, mesProductionLineList: f8e, mesWorkOrderTrackingList: g8e, mesProcessList: h8e, mesWipStatisticsList: E8e, mesProcessStatisticsList: y8e, mesTaskStatisticsList: T8e, mesUpsStatisticsList: _8e, mesOutBoundStatisticsList: b8e, mesBackBoundStatisticsList: V8e, wagesReport: w8e, mesFactoryWorkshopReport: S8e, mesGroupsReport: v8e, mesProductionStatisticsReport: R8e, mesTaskDelayNotifyReport: M8e, mesStudSleeveStatisticsList: A8e, mesProjectShipDetail: N8e, mesProjectShipDetailDirect: L8e, bridgeProjectDetail: I8e, enclosureProjectShipDetail: C8e, mesShipMeteDetail: P8e, mesShipTaskMeteDetail: O8e, mesShipInboundMeteDetail: k8e, mesShipTotalMeteDetail: D8e, mesShipMonthMeteDetail: x8e, mesShipStockMeteDetail: U8e, mesShipPackageMeteDetail: Y8e, mesShipMeteDetailDirect: K8e, mesShipTaskMeteDetailDirect: W8e, mesShipInboundMeteDetailDirect: j8e, mesShipTotalMeteDetailDirect: F8e, mesShipMonthMeteDetailDirect: z8e, mesShipStockMeteDetailDirect: B8e, mesShipTrainMeteDetailDirect: H8e, mesTeamWageSummary: q8e, mesTeamProduction: G8e, violationRecordReport: Q8e, mesDailyStatisticsSum: Z8e, mesDailyStatisticsProductionDetail: J8e, mesDailyStatisticsPackDetail: X8e, bridgeShipMeteDetail: n6e, bridgeShipTaskMeteDetail: s6e, bridgeShipInboundMeteDetail: r6e, bridgeShipTotalMeteDetail: u6e, bridgeShipMonthMeteDetail: c6e, bridgeShipStockMeteDetail: d6e, bridgeShipMeteDetailDirect: p6e, bridgeShipTaskMeteDetailDirect: h6e, bridgeShipInboundMeteDetailDirect: f6e, bridgeShipTotalMeteDetailDirect: g6e, bridgeShipMonthMeteDetailDirect: E6e, bridgeShipStockMeteDetailDirect: y6e, enclosureShipMeteDetail: T6e, enclosureShipTaskMeteDetail: _6e, enclosureShipInboundMeteDetail: b6e, enclosureShipTotalMeteDetail: V6e, enclosureShipMonthMeteDetail: w6e, enclosureShipStockMeteDetail: S6e, mesShipTrainMeteDetail: m6e, mesAuxMatDetail: v6e, bridgeAuxMatDetail: R6e, enclosureAuxMatDetail: M6e, mesProductSendReceiveStorage: A6e, mesDirectProductSendReceiveStorage: N6e, boxProductSendReceiveStorage: L6e, boxProductSendReceiveStorageDirect: I6e, enclosureProductSendReceiveStorage: C6e, productSendReceiveStorageDetail: P6e, boxProductSendReceiveStorageDetail: O6e, structureFinishedStartDetail: k6e, structureFinishedEndtDetail: D6e, structureFinishedInDetail: x6e, structureFinishedOutDetail: U6e, enclosureProductSendReceiveStorageDetail: Y6e, mesBeginningInventoryDetail: K6e, mesEndInventoryDetail: W6e, mesPackageInventoryDetail: j6e, mesInboundInventoryDetail: F6e, mesOutboundInventoryDetail: G6e, boxBeginningInventoryDetail: Q6e, boxEndInventoryDetail: Z6e, boxInboundInventoryDetail: J6e, boxOutboundInventoryDetail: X6e, sectionProductStartDetail: z6e, sectionProductEndDetail: B6e, sectionProductInDetail: H6e, sectionProductOutDetail: q6e, enclosureBeginningInventoryDetail: $6e, enclosureEndInventoryDetail: eMe, enclosureInboundInventoryDetail: tMe, enclosureOutboundInventoryDetail: iMe, enclosureTotalInboundInventoryDetail: oMe, enclosureTotalBeginningInventoryDetail: aMe, enclosureTotalOutboundInventoryDetail: nMe, enclosureTotalEndInventoryDetail: lMe, coatingProcess: $8e, lossStatistics: cMe, productionDetail: dMe, receiveDetail: mMe, shareReport: pMe, workInProgressInventoryStatistics: hMe, lossStatisticsV2: fMe, lossStatisticsSchedulingDetail: gMe, lossStatisticsReceiveDetail: EMe, lossStatisticsSteelFeedingDetail: yMe, lossStatisticsPartReportDetail: TMe, paintingCraftListPrint: e6e, paintingCraftListDetailPrint: t6e, workReportingRecord: i6e, manufacturesSalesReturnReport: _Me, structureAuxiliarySalesReturnAuditReport: bMe, enclosureAuxiliarySalesReturnAuditReport: VMe, structureSalesReturnAuditReport: wMe, enclosureSalesReturnAuditReport: SMe, wasteStorageReport: vMe, structureAuxiliaryWasteStorageAuditReport: RMe, enclosureAuxiliaryWasteStorageAuditReport: MMe, structureWasteStorageAuditReport: AMe, enclosureWasteStorageAuditReport: NMe, mesPaintTechnologyStatistics: a6e, mesPaintTechnologyListDetail: l6e, mesPaintTechnologyRecordArtifactPrint: o6e, bridgeSchedulingDetail: LMe, bridgeProductionTaskOrder: IMe, bridgeAssembleNestingOrder: CMe, bridgeAssembleProductionTaskOrder: PMe, bridgeNestingProductionTaskOrder: kMe, bridgeDrillProductionTaskOrder: OMe, bridgeStructureProductionReport: DMe, bridgeAssemblePartProductionReport: xMe, bridgeMachinePartProductionReport: UMe, bridgeEnclosureProductionReport: YMe, bridgeStructureProductionStatistics: KMe, bridgeStructureProductionStatisticsIn: WMe, bridgeStructureProductionStatisticsUn: jMe, bridgeStructureProductionStatisticsComplete: FMe, bridgeEnclosureProductionStatistics: zMe, bridgeEnclosureProductionStatisticsIn: BMe, bridgeEnclosureProductionStatisticsUn: HMe, bridgeEnclosureProductionStatisticsComplete: qMe, bridgeUnfinishedList: GMe, bridgeStructureProductionLine: QMe, bridgeStructureProcess: ZMe, bridgeMachinePartDetail: JMe, bridgeMachinePartList: XMe, bridgePaintingList: $Me, bridgeStructureProjectSummary: eAe, bridgeEnclosureProjectSummary: tAe, bridgeQHSEProductionLineReport: iAe, bridgeProjectOverviewList: aAe, bridgeStructureTeamWage: lAe, bridgeEnclosureTeamWage: oAe, bridgeStructureTeamWageDetail: nAe, bridgeEnclosureTeamWageDetail: sAe, bridgePackingList: rAe, bridgeShipmentSummary: uAe, bridgeShipmentDetail: cAe, bridgeReceiptStatusSummary: dAe, bridgeShippingList: mAe, bridgeShipmentAudit: pAe, bridgeLogisticsSummary: hAe, bridgeWarehouseStateStructure: fAe, bridgeWarehouseStateEnclosure: gAe, bridgeWarehouseStateReport: EAe, bridgeBoxClassList: yAe, bridgeElementClassList: TAe, bridgeMachinePartClassList: _Ae, bridgeMonthlyTaskList: bAe, bridgeProductionLineList: wAe, bridgeWorkOrderTrackingList: SAe, bridgeProcessList: VAe, bridgeFactoryWorkshopReport: vAe, bridgeStudSleeveStatisticsList: RAe, bridgeProjectShipDetail: MAe, bridgeProjectShipDetailDirect: AAe, bridgeProductSendReceiveStorage: NAe, bridgeProductSendReceiveStorageDetail: LAe, bridgestructureFinishedGoodsInventoryDetail: IAe, boxSummary: CAe, cellSummary: PAe, partSummary: OAe, wmsRmOutboundReceipt: kAe, wmsRmManufOutboundReceipt: DAe, wmsRmInboundReceipt: xAe, manufRmInboundReceipt: UAe, wmsRmReturnReceipt: YAe, wmsRmRejectReceipt: KAe, wmsRmTransferReceipt: WAe, wmsRmMoveMaterialReceipt: jAe, wmsRmMoveMaterialDetails: FAe, wmsRmSupplementReceipt: zAe, wmsScrapSell: BAe, wmsRmOutboundReceiptReport: HAe, wmsRmReturnReceiptReport: qAe, wmsRmTransferReceiptReport: GAe, deliveryCargoList: QAe, deliveryPartCargoList: ZAe, deliveryReportList: JAe, deliveryOutReportList: XAe, deliveryInstallList: $Ae, installReportList: eNe, productProcessList: tNe, productEnclosureProcessList: iNe, deepenProcessList: aNe, deepenEnclosureProcessList: lNe, receivingRecord: oNe, outReceivingRecord: nNe, outsourcingReturnRecord: sNe, outsourcingReceivingRecord: rNe, laborSettingList: uNe, laborInstallList: cNe, projectInstallList: dNe, auxiliaryMaterialSummary: mNe, schedulingDetailPrint: pNe, producedDetailPrint: hNe, notProducedDetailPrint: fNe, deliveryDetailPrint: gNe, enclosureSchedulingWorkOrderDetail: ENe, enclosureTaskTrackingDetail: yNe, enclosureProductionStatistics: TNe, enclosureTeamProduction: _Ne, enclosureTeamProductionDetail: bNe, businessSummaryReport: VNe, businessSummaryDetailReport: wNe, engineerInformationReport: SNe, businessBidReport: vNe, projectInfoReport: RNe, governmentReport: MNe, platFormReport: ANe, supplierReport: NNe, businessInfoList: LNe, supplierInfoList: INe, governmentInfoList: CNe, platFormInfoList: PNe, projectInfoList: ONe, bidInfoList: kNe, specificalBidInfoList: DNe, organizeBidInfoList: xNe, myProjectList: UNe, documentInfoList: YNe, bidProjectInfoList: KNe };
var Hd = null;
function a6() {
  try {
    var e = navigator.userAgent;
    if (e.match(/Windows\sPhone/i) || e.match(/iPhone|iPod|iPad/i) || e.match(/Android/i) || e.match(/Edge\D?\d+/i)) return true;
    var o = e.match(/Trident\D?\d+/i), n = e.match(/MSIE\D?\d+/i), c = e.match(/OPR\D?\d+/i), u = e.match(/Firefox\D?\d+/i), r = e.match(/x64/i);
    if (!o && !n && r) return true;
    if (u) {
      if (u = u[0].match(/\d+/), u[0] >= 41 || r) return true;
    } else if (c) {
      if (c = c[0].match(/\d+/), c[0] >= 32) return true;
    } else if (!o && !n) {
      var E = e.match(/Chrome\D?\d+/i);
      if (E && (E = E[0].match(/\d+/), E[0] >= 41)) return true;
    }
    return false;
  } catch {
    return true;
  }
}
// Printing is explicitly configured by the host; importing the application never probes devices.
async function FNe() {
  return rebuildGetConfiguredPrinter();
}
const zNe = { __name: "before-print-form", emits: ["submit"], setup(e, { expose: o, emit: n }) {
  const c = ZNe(), u = Z({ printer: 0, copies: 1 }), r = { printer: [{ required: true, message: "请选择打印机", trigger: "change" }], copies: [{ required: true, message: "请输入打印份数", trigger: "blur" }, { type: "number", min: 1, max: 999, message: "打印份数应在1到999之间", trigger: "blur" }] }, E = Z(null), y = n;
  return Ce(() => c, () => {
    u.value.printer = c.findIndex((V) => V.isDefault);
  }, { immediate: true }), o({ submitForm: async () => {
    try {
      return await E.value.validate(), y("submit", u.value), u.value;
    } catch (V) {
      return console.error("打印前表单验证失败:", V), {};
    }
  } }), (V, M) => {
    const g = zo, S = Bo, h = Zi, T = Bm, _ = Li;
    return w(), U(_, { ref_key: "formRef", ref: E, model: u.value, rules: r, size: "default", "label-width": "95px" }, { default: p(() => [s(h, { prop: "printer", label: "选择打印机" }, { default: p(() => [s(S, { modelValue: u.value.printer, "onUpdate:modelValue": M[0] || (M[0] = (f) => u.value.printer = f), placeholder: "选择打印机", style: { width: "100%" } }, { default: p(() => [(w(true), Q(Qe, null, ki(l(c), (f) => (w(), U(g, { key: f.value, label: f.label, value: f.value }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"])]), _: 1 }), s(h, { prop: "copies", label: "打印份数" }, { default: p(() => [s(T, { modelValue: u.value.copies, "onUpdate:modelValue": M[1] || (M[1] = (f) => u.value.copies = f), modelModifiers: { number: true }, min: 1, max: 999, style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"]);
  };
} };
let Oi, Qs = false, l6 = 0, ir = [], ar = [], o6 = ar, n6 = ir, Om = false, hn = true, fn = true, Zs = "", qd = "";
const $r = 500, BNe = 30, HNe = 1e4;
let cs = null;
async function qNe() {
  try {
    Oi = await FNe();
    Oi.PRINT_INIT("");
    Oi.SET_PRINT_MODE("RESELECT_COPIES", true);
    GNe();
    return Oi;
  } catch (error) {
    ot({message: error.message || "本地打印适配器不可用。", type: "warning"});
    throw error;
  }
}
function GNe() {
  Qs = false, l6 = 0, n6 = ir, o6 = ar, ir = [], ar = [], Om = false, hn = true, fn = true;
}
async function QNe(e) {
  let o = false;
  switch (e) {
    case Kl.NORMAL.V:
      o = Gd();
      break;
    case Kl.QUEUE.V:
      o = await Jb();
      break;
    case Kl.RESULT.V:
      o = await $Ne();
      break;
    case Kl.PREVIEW.V:
      o = await JNe();
      break;
    case Kl.PRINT_DESIGN.V:
      o = XNe();
      break;
    case Kl.CUSTOM_NORMAL.V:
      o = await Zb({ printFunc: Gd });
      break;
    case Kl.CUSTOM_QUEUE.V:
      o = await Zb({ printFunc: Jb });
      break;
    default:
      o = Gd();
      break;
  }
  return o;
}
function Zb({ printFunc: e }) {
  return new Promise((o, n) => {
    zi({ title: "打印设置", customClass: "global-before-print-dialog", message: KM(zNe), showCancelButton: true, confirmButtonText: "确定", cancelButtonText: "取消", beforeClose: async (c, u, r) => {
      if (c === "confirm") try {
        let E = false;
        const y = u.message.component.exposed, b = await (y == null ? void 0 : y.submitForm());
        console.log(`选中的设备是 ${b.printer}，将打印 ${b.copies} 份`), Oi.SET_PRINTER_INDEX(b.printer), Oi.SET_PRINT_COPIES(b.copies), r(), typeof e == "function" && (E = await e()), Oi.SET_PRINT_MODE("WINDOW_DEFPRINTER", b.printer), Zs = Oi.GET_PRINTER_NAME(b.printer), o(E);
      } catch (E) {
        console.error("操作失败:", E), n(E);
      }
      else console.error("取消操作"), r(), o(false);
    } });
  });
}
function ZNe() {
  console.log("获取打印机列表");
  const e = Oi.GET_PRINTER_COUNT();
  Zs || (Zs = Oi.GET_PRINTER_NAME(-1)), console.log("默认打印机", Zs);
  const o = [];
  for (let n = 0; n < e; n++) {
    const c = Oi.GET_PRINTER_NAME(n), u = c === Zs;
    o.push({ isDefault: u, value: n, label: c });
  }
  return o;
}
function Gd() {
  return rebuildRequirePrintResult(Oi.PRINT(), "打印");
}
async function JNe() {
  return Oi.SET_PRINT_MODE("RESELECT_ORIENT", true), new Promise((e, o) => {
    let n = false;
    Oi.On_Return = (c, u) => {
      Number(u) === 1 && (n = "printed"), e(n);
    }, rebuildRequirePrintResult(Oi.PREVIEW(), "打印预览");
  });
}
function XNe() {
  return rebuildRequirePrintResult(Oi.PRINT_DESIGN(), "打印设计");
}
async function Jb() {
  return new Promise((e, o) => {
    let n;
    Oi.CVERSION ? (Oi.On_Return = (c, u) => {
      try { console.log("TaskID", c, u), n = rebuildRequirePrintResult(u, "队列打印"), e(n); }
      catch (error) { o(error); }
    }, rebuildRequirePrintResult(Oi.PRINT(), "队列打印")) : (n = rebuildRequirePrintResult(Oi.PRINT(), "队列打印"), e(n));
  });
}
async function $Ne() {
  const e = { value: "" };
  if (Oi.SET_PRINT_MODE("CATCH_PRINT_STATUS", true), Oi.CVERSION) {
    let o = 0;
    Oi.On_Return = async (u, r) => {
      if (o++, e.value = r, console.log("第一次ON_RETURN C-LODOP: 获取JOB代码", u, r), r.toString().indexOf("该打印机在“云服务器工作模式”下被禁用") > -1) return setTimeout(() => {
        alert("请启动LODOP或C-LODOP");
      }, 500), false;
      if (o > 0 && (console.log("getTaskTimeout-------------", cs), cs && clearTimeout(cs), cs = setTimeout(async () => (clearTimeout(cs), console.log("无法获取到正确的JOB代码,并清空队列", qd), await Hr(qd), false), HNe)), n6.indexOf(u) === -1 && o6.indexOf(u) === -1) return cs && clearTimeout(cs), qd = s6(r), await Xb(e);
    };
    let n = false;
    console.log("-----------------PRINT------------------clodop");
    let c = 0;
    do {
      if (c++ > $r) throw new Error("PRINT-while超时");
      Oi.blOneByone === false ? (Oi.PRINT(), n = true) : (console.log("窗体存在--------------------延迟500:PRINT", Oi.blOneByone), await Vs(500));
    } while (Oi.blOneByone === true && n);
    console.log("-----------------PRINT—END------------------clodop");
  } else return e.value = Oi.PRINT(), console.log("第一次ON_RETURN LODOP: 获取JOB代码", e.value), await Xb(e);
}
async function Xb(e) {
  console.log("轮序接收到的JOB代码", e);
  for (let o = 0; o < BNe; o++) {
    if (console.log("轮询------------------------------------------", o, Oi.blOneByone), Qs) return true;
    await $b("PRINT_STATUS_OK", e.value);
    let n = 0;
    for (; !hn; ) {
      if (n++ > $r) throw await Hr(e.value), new Error("等待回调-OK-while超时");
      console.log(`------------------等待回调-OK------------------${hn},${fn}`), await Vs(500);
    }
    for (await $b("PRINT_STATUS_EXIST", e.value), n = 0; !fn; ) {
      if (n++ > $r) throw await Hr(e.value), new Error("等待回调-EXIST-while超时");
      console.log(`------------------等待回调-EXIST------------------${hn},${fn}`), await Vs(500);
    }
  }
  return await Hr(e.value), false;
}
async function $b(e, o) {
  let n = null;
  if (Oi.CVERSION) {
    let c = false;
    Oi.On_Return_Remain = true, Oi.On_Return = (r, E) => {
      console.log(`任务ID：${r}     任务完成ID：${ir}     任务队列ID：${ar}     结果：${E}`), ir.indexOf(r) > -1 ? (hn = true, +E == 1 && (console.log("------------------打印成功------------------"), Qs = true)) : ar.indexOf(r) > -1 ? (fn = true, +E == 0 && (console.log("------------------已出队列------------------"), Qs = true)) : (hn = true, fn = true, console.log("-----------------不匹配情况-----------------", E));
    }, console.log(`------------------GET_VALUE------------------${e}`);
    let u = 0;
    do {
      if (u++ > $r) throw await Hr(o), new Error("GET_VALUE-while超时");
      Oi.blOneByone === false ? (n = Oi.GET_VALUE(e, o), c = true) : (console.log("窗体存在--------------------延迟500:GET_VALUE", Oi.blOneByone), await Vs(500));
    } while (Oi.blOneByone === true && c);
    console.log("------------------GET_VALUE-END------------------"), e === "PRINT_STATUS_OK" && (hn = false, ir.push(n)), e === "PRINT_STATUS_EXIST" && (fn = false, ar.push(n));
  }
  Oi.CVERSION || (console.log("------------------GET_VALUE------------------LODOP"), n = Oi.GET_VALUE(e, o), e === "PRINT_STATUS_OK" && (hn = false, console.log("OK-------------------", n), n && (Qs = true, hn = true)), e === "PRINT_STATUS_EXIST" && (fn = false, console.log("EXIST-------------------", n), !n && l6 > 0 && (Qs = true, fn = true)));
}
async function Hr(e) {
  if (Om) return;
  Om = true, console.log("清除任务");
  const o = s6(e);
  if (Oi.CVERSION) {
    Oi.On_Return = (r, E) => {
      console.log("清理结果:" + E), E.toLowerCase();
    };
    let c = false;
    console.log("-----------------SET_PRINT_MODE------------------clodop");
    let u = 0;
    do {
      if (u++ > $r) throw new Error("SET_PRINT_MODE-while超时");
      Oi.blOneByone === false ? (Oi.SET_PRINT_MODE("CONTROL_PRINTER:" + o, "PURGE"), c = true) : (console.log("窗体存在--------------------延迟500:SET_PRINT_MODE-清除", Oi.blOneByone), await Vs(500));
    } while (Oi.blOneByone === true && c);
    return;
  } else {
    var n = Oi.SET_PRINT_MODE("CONTROL_PRINTER:" + o, "PURGE");
    console.log("清理结果:" + n);
  }
}
function s6(e) {
  var o = e.indexOf("_");
  return o < 0 ? e : e.substr(0, o);
}
function e5e() {
  zi.confirm(`请下载Web打印控件
下载后刷新页面重试
地址：http://www.LODOP.net/index.html`, "请下载打印控件", { showCancelButton: false, confirmButtonText: "确认", type: "warning" });
}
function v0t(e, o) {
  let n = "";
  return n = `<!DOCTYPE html>
          <html>
          <head>
            ${e}
          </head>
          <body>
            ${o}
          </body>
        </html>`, n;
}
function t5e(e, o) {
  let n = "";
  return e === 210 && o === 297 && (n = "A4"), n;
}
let Ua;
const Lr = 2;
async function i5e({ header: e, table: o, footer: n, qrCode: c, config: u, printMode: r = Kl.QUEUE.V } = {}, E = 1) {
    if (Ae(u)) throw new Error("打印未配置");
    let V = false;
    try {
      a5e(u.table), m5e(u);
      const g = l5e(u.title), S = u5e({ header: e, footer: n, table: o, globalConfig: u }), h = r6(n, u), T = n5e(u.page), _ = s5e(u.logo);
      let f = u.paddingTB, m = 0;
      const R = 3;
      if (r === Kl.PREVIEW?.V && !rebuildHasConfiguredPrinter()) {
        const barcode = u.qrCode?.show && c
          ? `<img alt="二维码" width="100" height="100" src="${WV.getQrBase64(c)}">`
          : "";
        const footer = u.footer?.show && !u.footer.allPage ? h : "";
        return await rebuildShowReportPreview({ title: u.title?.title, html: _ + g + S + footer + barcode });
      }
      Ua = await qNe();
      const v = async () => {
        const N = u.orient || $n.LONGITUDINAL.V;
        t5e(u.width, u.height) ? Ua.SET_PRINT_PAGESIZE(N, 0, 0, u.pageSize) : Ua.SET_PRINT_PAGESIZE(N, u.width + u.unit, u.height + u.unit, "CreateCustomPage"), Ua.ADD_PRINT_HTM(`${f}${u.unit}`, 0, "100%", `${u.title.height}${u.unit}`, g), Ua.SET_PRINT_STYLEA(0, "ItemType", 1), A(u.title) && u.title.show && (f += u.title.height, u.title.allPage || (Ua.SET_PRINT_STYLEA(0, "PageIndex", "first"), m += u.title.height)), A(u.header) && u.header.show && !u.header.allPage && (m += u.header.height), A(u.title) && u.title.show && (Ae(u.header) || !u.header.show) && (f += R, u.title.allPage || (m += R));
        const L = St(8, "mm", u.unit);
        if (Ua.ADD_PRINT_TABLE(`${f}${u.unit}`, 0, "100%", `BottomMargin:${u.paddingTB + L}${u.unit}`, S), Ua.SET_PRINT_STYLEA(0, "TableHeightScope", 1), Ua.SET_PRINT_STYLEA(0, "TableRowThickNess", "30px"), m && Ua.SET_PRINT_STYLEA(0, "Offset2Top", `${-m}${u.unit}`), A(u.footer) && u.footer.show && u.footer.height && !u.footer.allPage && (Ua.ADD_PRINT_HTM(`1${u.unit}`, 0, "100%", `${u.footer.height}${u.unit}`, h), Ua.SET_PRINT_STYLEA(0, "LinkedItem", -1)), A(u.page) && u.page.show) {
          const O = St(6, "mm", u.unit);
          Ua.ADD_PRINT_HTM(`${u.height - O - u.page.bottom}${u.unit}`, 0, "100%", `${O + u.page.bottom}${u.unit}`, T), Ua.SET_PRINT_STYLEA(0, "ItemType", 1);
        }
        if (A(u.logo) && u.logo.show && u.logo.url && (Ua.ADD_PRINT_HTM(`${u.logo.top}${u.unit}`, `${u.logo.left}${u.unit}`, `${u.logo.width}${u.unit}`, `${u.logo.height}${u.unit}`, _), Ua.SET_PRINT_STYLEA(0, "ItemType", 1), u.logo.allPage || Ua.SET_PRINT_STYLEA(0, "PageIndex", "first")), A(u.qrCode) && u.qrCode.show && A(c)) {
          const O = St(1, "mm", u.unit);
          Ua.ADD_PRINT_BARCODE(`${u.qrCode.top}${u.unit}`, `${u.qrCode.left + O}${u.unit}`, `${u.qrCode.width}${u.unit}`, `${u.qrCode.height}${u.unit}`, "QRCode", c), Ua.SET_PRINT_STYLEA(0, "QRCodeVersion", 5), Ua.SET_PRINT_STYLEA(0, "QRCodeErrorLevel", "M"), Ua.SET_PRINT_STYLEA(0, "ItemType", 1), u.qrCode.allPage || Ua.SET_PRINT_STYLEA(0, "PageIndex", "first");
        }
        Ua.SET_PRINT_COPIES(E), V = await QNe(r);
        return V;
      };
      if (A(u.logo) && u.logo.show && u.logo.url) {
        await new Promise((resolve) => {
          const image = new Image();
          image.onload = resolve;
          image.onerror = (error) => { console.log("img error: ", error); ot.warning("获取logo失败"); resolve(); };
          image.src = u.logo.url;
        });
      }
      return await v();
    } catch (g) {
      ot({message: g.message || "打印失败", type: "error"});
      throw g;
    }
}
function a5e(e) {
  e && (e.columns = i2(JSON.parse(JSON.stringify(e.fields))), e.columnRows = a2(e.columns), e.lastColumns = l2(e.columnRows));
}
function l5e(e) {
  if (Ae(e) || !e.show) return "";
  let o = C5e + e.style;
  return o += `<div class="title-content">${e.title || ""}</div>`, o;
}
function o5e(e, o) {
  if (!o) return "";
  let n = "";
  if (o.show && o.fields) {
    n += m6 + o.style, n += `<div class="header-content" style="text-align:${kn(o.align)}">`;
    for (const c of o.fields) if (c.show) {
      if (n += `<div class="header-content-item" style="${c.style}">`, n += '<div style="display: inline;zoom: 1;">', (c.title || e && c.key) && (n += `<div style="position: absolute;${c6(o.verticleAlign)}">`), c.title && (n += `<span style="font-weight:${o.bold}">${c.title}</span>`), e && c.key) {
        const u = Rd({ row: e, field: c, emptyVal: o.emptyVal });
        n += A(u) ? `<span>${u}</span>` : "";
      }
      (c.title || e && c.key) && (n += "</div>"), n += "</div></div>";
    }
    n += "</div>";
  }
  return n;
}
function r6(e, o) {
  const n = o.footer;
  if (!n || !n.show) return "";
  const c = n.tip;
  let u = "";
  if (u += O5e + n.style, u += `<div class="footer-content" style="text-align:${kn(n.align)}">`, c && c.show && c.above && (u += `<span class="tip" style="font-size:${c.size}${o.fontUnit};font-weight:${c.bold};text-align:${kn(c.align)}">${A(c.text) ? c.text : ""}</span>`), n.fields) {
    for (const r of n.fields) if (r.show) {
      if (u += `<div class="footer-content-item" style="${r.style}">`, u += '<div style="display: inline;zoom: 1;">', (r.title || e && r.key) && (u += `<div style="position: absolute;${c6(n.verticleAlign)}">`), r.title && (u += `<span style="font-weight:${n.bold}">${r.title}</span>`), e && r.key) {
        const E = Rd({ row: e, field: r, emptyVal: n.emptyVal });
        u += A(E) ? `<span>${E}</span>` : "";
      }
      (r.title || e && r.key) && (u += "</div>"), u += "</div></div>";
    }
  }
  return c && c.show && !c.above && (u += `<span class="tip" style="font-size:${c.size}${o.fontUnit};font-weight:${c.bold};text-align:${kn(c.align)}">${A(c.text) ? c.text : ""}</span>`), u += "</div>", u;
}
function n5e(e) {
  if (Ae(e) || !e.show) return "";
  let o = k5e + e.style;
  return o += `<div class="page-content">${I5e(e.format)}</div>`, o;
}
function s5e(e) {
  if (Ae(e) || !e.show) return "";
  let o = D5e + e.style;
  return o += `<div class="logo-content"><img src=${e.url} class="logo-img" /></div>`, o;
}
function r5e(e, o) {
  const n = e.columnRows;
  let c = "";
  return n.forEach((u, r) => {
    if (c += "<tr>", r === 0 && e.index && e.index.show) {
      const E = e.index.style;
      c += `<td class="th" rowspan="${n.length}" style="${E}"><div style="${E}">${e.index.title || "序号"}</div></td>`;
    }
    u.forEach((E) => {
      E.show && (c += `<td class="th" colspan="${E.colSpan}" rowspan="${E.rowSpan}" style="${E.style}"><div style="${E.style}">${E.title || ""}</div></td>`);
    }), r === 0 && o && (c += '<td class="th blank-column" scope="col"><div></div></td>'), c += "</tr>";
  }), c;
}
function u5e({ header: e, footer: o, table: n, globalConfig: c }) {
  if (!c) return "";
  let u = d5e(c);
  const r = c.table, E = o5e(e, c.header), y = r6(o, c);
  let b = r.fields.filter((g) => g.show).length;
  r.index && r.index.show && ++b, u += `
    <div class="table-content" >
      <table class="print-table" border="0">`, A(c.header) && c.header.show && !c.header.allPage && (u += `<caption>${E}</caption>`), u += "<thead>", A(c.header) && c.header.show && c.header.allPage && (u += `<tr><th colspan="${b}">${E}</th></tr>`);
  const V = r.index && r.index.show && A(r.index.width) && r.lastColumns.every((g) => A(g.width));
  u += `${r5e(r, V)}`, u += `</thead>
        <tbody>
        `;
  let M = 0;
  for (const g of n) {
    if (u += "<tr>", r.index && r.index.show) {
      const S = r.index.style;
      u += `<td class="td" style="${S}"><div style="${S}">${M + 1}</div></td>`;
    }
    for (const S of r.lastColumns) {
      const h = Rd({ row: g, field: S, emptyVal: r.emptyVal });
      S.type === a.IMAGE.K ? u += `<td style="${S.style}"><div style="height:${S.height}mm;${S.style}">${h}</div></td>` : u += `<td class="td" style="${S.style}"><div style="${S.style}">${h}</div></td>`;
    }
    V && (u += '<td class="td blank-column"><div></div></td>'), u += "</tr>", ++M;
  }
  return r.summary && r.summary.show && (u += c5e(n, r, V)), u += `
        </tbody>
        <tfoot>`, A(c.footer) && c.footer.show && c.footer.allPage && (u += `<tr><th colspan="${b}" style="text-align:left">${y}</th></tr>`), u += `</tfoot>
      </table>
    </div>
    `, u;
}
function c5e(e, o, n) {
  let c = "<tr>";
  if (o.index && o.index.show) {
    const u = o.index.style;
    c += `<td class="td" style="${u}"><div style="${u}">${o.summary.title || "合计"}</div></td>`;
  }
  for (const u of o.lastColumns) if (u.show) {
    let r = "";
    if (u && u.sum) {
      r = 0;
      const E = e.map((V) => d6(V, u.key));
      let y = 0;
      const b = [];
      if (!E.every((V) => isNaN(+V))) {
        r = E.reduce((M, g) => {
          const S = Number(g);
          return isNaN(S) ? M : (b.push(Ho(g)), M + Number(g));
        }, 0), y = b.getMax(), y = y > 5 ? 5 : y;
        const V = JSON.parse(JSON.stringify(u));
        V.format || (V.format = {}), Ae(V.format.precision) && (V.format.precision = y), r = Rd({ val: r, field: V });
      }
    }
    c += `<td class="td" style="${u.style}"><div style="${u.style}">${r}</div></td>`;
  }
  return n && (c += '<td class="td blank-column"><div></div></td>'), c += "</tr>", c;
}
function d5e(e) {
  let o = m6 + P5e + Ir;
  return A(e.header) && e.header.show && (o += e.header.style), o += e.table.style, o;
}
function m5e(e) {
  p5e(e), h5e(e), f5e(e), g5e(e), E5e(e), y5e(e);
}
function p5e(e) {
  const o = e.title;
  if (e && A(o) && o.show) {
    let n = `<style> 
        .title-content {`;
    A(o.size) && (n += `font-size:${o.size}${e.fontUnit};`), A(o.bold) && (n += `font-weight:${o.bold};`), A(o.height) && (n += `height:${o.height}${e.unit};`), A(o.width) && (n += `width:${o.width}${e.unit};`), A(e.paddingLR) && (n += `padding:0 ${e.paddingLR}${e.unit};`), n += "}</style>", o.style = n;
  }
}
function h5e(e) {
  const o = e.header;
  if (e && A(o) && o.show) {
    _5e(e);
    let n = `<style> 
        .header-content {`;
    A(o.width) && (n += `width: ${o.width}${e.unit};`), A(o.height) && (n += `height: ${o.height}${e.unit};`), A(o.size) && (n += `font-size: ${o.size}${e.fontUnit};`), n += "}</style>", o.style = n;
  }
}
function f5e(e) {
  const o = e.footer;
  if (e && A(o) && o.show) {
    b5e(e);
    let n = `<style> 
        .footer-content {`;
    if (A(e.footer) && e.footer.show && !e.footer.allPage && A(e.paddingLR) && (n += `padding:0 ${e.paddingLR}${e.unit};`), A(o.width)) {
      const c = e.footer.allPage ? o.width : o.width + (e.paddingLR || 0) * 2;
      n += `width:${c}${e.unit};`;
    }
    A(o.height) && (n += `height:${o.height}${e.unit};`), A(o.size) && (n += `font-size:${o.size}${e.fontUnit};`), n += `}
    </style>`, o.style = n;
  }
}
function g5e(e) {
  const o = e.page;
  if (e && A(o) && o.show) {
    let n = `<style> 
        .page-content {`;
    A(e.paddingLR) && (n += `padding-left: ${e.paddingLR || 0}${e.unit};`, n += `padding-right: ${e.paddingLR || 0}${e.unit};`), A(o.bottom) && (n += `bottom: ${o.bottom}${e.unit};`), A(o.size) && (n += `font-size: ${o.size}${e.fontUnit};`), A(o.bold) && (n += `font-weight: ${o.bold};`), A(o.align) && (n += `text-align: ${kn(o.align)};`), n += "}</style>", o.style = n;
  }
}
function E5e(e) {
  const o = e.logo;
  if (e && A(o) && o.show) {
    let n = `<style> 
    .logo-content {`;
    A(o.width) && (n += `width:${o.width}${e.unit};`), A(o.height) && (n += `height:${o.height}${e.unit};`), n += `}
        .logo-img {`, A(o.width) && (n += `width:${o.width}${e.unit};`), n += "}</style>", o.style = n;
  }
}
function y5e(e) {
  const o = e.table;
  if (e && A(o)) {
    T5e(e);
    let n = `<style> 
        .table-content {`;
    A(e.width) && (n += `width:${e.width}${e.unit};`), A(e.paddingLR) && (n += `padding:0 ${e.paddingLR}${e.unit};`), n += "}", A(o.th) && (n += `
      .print-table .th {`, A(o.th.size) && (n += ` font-size: ${o.th.size}${e.fontUnit};`), A(o.th.bold) && (n += ` font-weight: ${o.th.bold};`), A(o.th.lineHeight) && (n += ` line-height: ${o.th.lineHeight}${e.fontUnit}!important;`), A(e.footer) && e.footer.show && e.footer.allPage && (n += "border-bottom: none;"), n += "}", n += `
      .print-table .th >div{`, A(o.th.paddingTB) && (n += ` padding-top: ${o.th.paddingTB}${e.unit}!important;`, n += ` padding-bottom: ${o.th.paddingTB}${e.unit}!important;`), n += "}"), A(o.td) && (n += `
      .print-table .td {`, A(o.td.size) && (n += ` font-size: ${o.td.size}${e.fontUnit};`), A(o.td.bold) && (n += ` font-weight: ${o.td.bold};`), A(o.td.lineHeight) && (n += ` line-height: ${o.td.lineHeight}${e.fontUnit}!important;`), n += "}", n += `
      .print-table .td >div{`, A(o.td.paddingTB) && (n += ` padding-top: ${o.td.paddingTB}${e.unit}!important;`, n += ` padding-bottom: ${o.td.paddingTB}${e.unit}!important;`), n += "}"), n += "</style>", o.style = n;
  }
}
function T5e(e) {
  const o = e.table;
  if (e && A(o)) {
    o.columnRows.forEach((u) => {
      u.forEach((r) => {
        let E = "";
        A(r.align) && (E += `text-align:${kn(r.align)};`), A(r.width) ? E += `width:${r.width}${e.unit};` : A(r.minWidth) && (E += `min-width:${r.minWidth}${e.unit};`), r.style = E;
      });
    });
    const c = o.index;
    if (A(o.index)) {
      let u = "";
      A(c.align) && (u += `text-align:${kn(c.align)};`), A(c.width) ? u += `width:${c.width}${e.unit};` : A(c.minWidth) && (u += `min-width:${c.minWidth}${e.unit};`), c.style = u;
    }
  }
}
