function dVe(e) {
  return W({ url: "/api/mes/building/production-wage-manage/yield-confirm/apportion-report/print", method: "get", params: e });
}
function mVe(e) {
  return W({ url: "/api/mes/building/task/process/produce/statistics/detail/print", method: "get", params: e });
}
function pVe(e) {
  return W({ url: "/api/mes/building/task/loss_statistics/print", method: "get", params: e });
}
function hVe(e) {
  return W({ url: "/api/mes/building/task/loss_statistics_detail/print", method: "get", params: e });
}
function fVe(e) {
  return W({ url: "/api/mes/building/task/getReceiveDateDetail/print", method: "get", params: e });
}
function gVe(e) {
  return W({ url: "/api/mes/building/task/steel_feeding_detail/print", method: "get", params: e });
}
function EVe(e) {
  return W({ url: "/api/mes/building/task/part_report_detail/print", method: "get", params: e });
}
function yVe(e) {
  return W({ url: "/api/mes/building/project/statistics/production/task/detail/print", method: "get", params: e });
}
function TVe(e) {
  return W({ url: "/api/mes/building/project/statistics/production/team/detail/print", method: "get", params: e });
}
function _Ve(e) {
  return W({ url: "/api/mes/building/production/signage/project/product/production/state/print", method: "get", params: e });
}
function bVe(e) {
  return W({ url: "/api/mes/building/labor-management/behavior-score/violation-record/print", method: "get", params: e });
}
function VVe(e) {
  return W({ url: "/api/mes/building/quota-config/team-salary/print", method: "get", params: e });
}
function wVe(e) {
  return W({ url: "/api/mes/building/quota-config/team-salary/team-production-list/print", method: "get", params: e });
}
function SVe(e) {
  return W({ url: "/api/mes/building/cargo/day_or_month/summary/print", method: "get", params: e });
}
function vVe(e) {
  return W({ url: "/api/mes/building/daily/statistics/production/task/sum/print", method: "get", params: e });
}
function RVe(e) {
  return W({ url: "/api/mes/building/daily/statistics/production/detail/print", method: "get", params: e });
}
function MVe(e) {
  return W({ url: "/api/mes/building/daily/statistics/print/production/pack/detail", method: "get", params: e });
}
function AVe(e) {
  return W({ url: "/api/mes/building/craft/painting-craft/list-print", method: "get", params: e });
}
function NVe(e) {
  return W({ url: "/api/mes/building/craft/painting-craft/approval-detail-print", method: "get", params: e });
}
function LVe(e) {
  return W({ url: "/api/mes/building/production/signage/project/teamReport/product/print", method: "get", params: e });
}
function IVe(e) {
  return W({ url: "/api/mes/building/paint/technology/paintCalculateRecord/print", method: "get", params: e });
}
function CVe(e) {
  return W({ url: "/api/mes/building/paint/technology/related/artifact/list/print", method: "get", params: e });
}
function PVe(e) {
  return W({ url: "api/mes/building/paint/technology/paintCalculateRecord/structureClass/artifact/list/print", method: "get", params: e });
}
const mt = { machinePartDetail: D2e, machinePartList: x2e, paintingList: U2e, structureProjectSummary: Y2e, enclosureProjectSummary: K2e, projectOverviewList: qbe, mesSchedulingDataList: Gbe, schedulingDetail: L2e, productionTaskOrder: I2e, productionTaskOrders: C2e, assembleNestingOrder: O2e, assembleProductionTaskOrder: P2e, drillProductionTaskOrder: k2e, productionReport: S2e, productionStatistics: v2e, productionStatisticsIn: R2e, productionStatisticsUn: M2e, productionStatisticsComplete: A2e, unfinishedList: N2e, qhseProductionLineReport: W2e, enclosureProductionLine: T2e, structureProductionLine: _2e, structureProcess: b2e, teamWage: V2e, teamWageDetail: w2e, packingList: O_e, bridgePackingList: k_e, enclosurePackingList: D_e, shipmentSummary: x_e, bridgeShipmentSummary: U_e, shipmentDetail: Y_e, bridgeShipmentDetail: K_e, receiptStatusSummary: W_e, shippingList: F_e, mesBridgeReceiptStatusSummary: j_e, mesBridgeShippingList: z_e, shipmentAudit: B_e, mesShipmentAuditDetail: H_e, shipmentAuditOverWeight: q_e, mesBridgeShipmentAudit: G_e, mesBridgeShipmentAuditOverWeight: Q_e, logisticsSummary: Z_e, bridgeLogisticsSummary: J_e, warehouseStateStructure: X_e, warehouseStateEnclosure: $_e, warehouseStateReport: e2e, mesBeginningInventoryDetail: t2e, mesEndInventoryDetail: i2e, mesPackageInventoryDetail: o2e, mesInboundInventoryDetail: a2e, mesOutboundInventoryDetail: l2e, boxBeginningInventoryDetail: n2e, boxEndInventoryDetail: s2e, boxInboundInventoryDetail: r2e, boxOutboundInventoryDetail: u2e, enclosureBeginningInventoryDetail: d2e, enclosureEndInventoryDetail: m2e, enclosureInboundInventoryDetail: p2e, enclosureOutboundInventoryDetail: h2e, enclosureTotalInboundInventoryDetail: g2e, enclosureTotalBeginningInventoryDetail: f2e, enclosureTotalOutboundInventoryDetail: E2e, enclosureTotalEndInventoryDetail: y2e, artifactClassList: j2e, assembleClassList: F2e, machinePartClassList: z2e, productionKanbanList: B2e, productionKanbanGroupList: H2e, mesProjectShipDetail: q2e, mesProjectShipDetailDirect: G2e, bridgeProjectShipDetail: Q2e, bridgeProjectShipDetailDirect: Z2e, enclosureProjectShipDetail: J2e, mesShipMeteDetailDirect: $2e, mesShipMeteDetail: X2e, mesShipTaskMeteDetail: ebe, mesShipInboundMeteDetail: tbe, mesShipTotalMeteDetail: ibe, mesShipMonthMeteDetail: abe, mesShipStockMeteDetail: lbe, mesShipPackageMeteDetail: obe, bridgeShipMeteDetail: nbe, bridgeShipMeteDetailDirect: sbe, bridgeShipTaskMeteDetail: rbe, bridgeShipInboundMeteDetail: ube, bridgeShipTotalMeteDetail: cbe, bridgeShipMonthMeteDetail: dbe, bridgeShipStockMeteDetail: mbe, enclosureShipMeteDetail: pbe, enclosureShipTaskMeteDetail: hbe, enclosureShipInboundMeteDetail: fbe, enclosureShipTotalMeteDetail: gbe, enclosureShipMonthMeteDetail: Ebe, enclosureShipStockMeteDetail: ybe, mesShipTrainMeteDetail: Tbe, mesAuxMatDetail: _be, bridgeAuxMatDetail: bbe, enclosureAuxMatDetail: Vbe, manufacturesSalesReturnReport: wbe, structureAuxiliarySalesReturnAuditReport: Sbe, enclosureAuxiliarySalesReturnAuditReport: vbe, structureSalesReturnAuditReport: Rbe, enclosureSalesReturnAuditReport: Mbe, wasteStorageReport: Abe, structureAuxiliaryWasteStorageAuditReport: Nbe, enclosureAuxiliaryWasteStorageAuditReport: Lbe, structureWasteStorageAuditReport: Ibe, enclosureWasteStorageAuditReport: Cbe, factoryWorkshopReport: Pbe, groupsReport: Obe, productionStatisticsReport: kbe, taskDelayNotifyReport: Dbe, workOrderTrackingList: xbe, monthlyTaskList: Ube, productionLineList: Ybe, processList: Kbe, wipStatisticsLis: Wbe, processStatisticsList: jbe, taskStatisticsList: Fbe, upsStatisticsList: zbe, outBoundStatisticsList: Bbe, backBoundStatisticsList: Hbe, productSendReceiveStorage: Qbe, boxProductSendReceiveStorage: eVe, enclosureProductSendReceiveStorage: Zbe, productSendReceiveStorageDetail: Jbe, boxProductSendReceiveStorageDetail: tVe, enclosureProductSendReceiveStorageDetail: $be, sectionProductInventoryDetail: c2e, structureFinishedGoodsInventoryDetail: Xbe, mainMaterialTrackSummary: aVe, mainMaterialTrackUseRecord: lVe, mainMaterialTrackStock: oVe, coatingProcess: nVe, studSleeveStatisticsList: sVe, wagesReport: iVe, shareReport: dVe, cargoDayOrMonthSummary: SVe, lossStatistics: rVe, productionDetail: uVe, receiveDetail: cVe, workInProgressInventoryStatistics: mVe, lossStatisticsV2: pVe, lossStatisticsSchedulingDetail: hVe, lossStatisticsReceiveDetail: fVe, lossStatisticsSteelFeedingDetail: gVe, lossStatisticsPartReportDetail: EVe, projectProductionPrint: yVe, projectTeamGroupPrint: TVe, productionDetailPrint: _Ve, violationRecordReport: bVe, mesTeamWageSummary: VVe, mesTeamProduction: wVe, mesDailyStatisticsSum: vVe, mesDailyStatisticsProductionDetail: RVe, mesDailyStatisticsPackDetail: MVe, paintingCraftListPrint: AVe, paintingCraftListDetailPrint: NVe, workReportingRecord: LVe, mesPaintTechnologyStatistics: IVe, mesPaintTechnologyListDetail: CVe, mesPaintTechnologyRecordArtifactPrint: PVe };
function OVe(e) {
  return W({ url: `api/mes/bridge/package/${e}/print`, method: "get" });
}
function kVe(e) {
  return W({ url: "api/mes/bridge/cargo/ship/print", method: "get", params: e });
}
function DVe(e) {
  return W({ url: `api/mes/bridge/cargo/ship/${e}/print`, method: "get" });
}
function xVe(e) {
  return W({ url: "api/mes/bridge/cargo/receipt/print", method: "get", params: e });
}
function UVe(e) {
  return W({ url: `api/mes/bridge/cargo/receipt/${e}/print`, method: "get" });
}
function YVe(e) {
  return W({ url: "api/mes/bridge/cargo/review/print", method: "get", params: e });
}
function KVe(e) {
  return W({ url: "api/mes/bridge/cargo/logistics/print", method: "get", params: e });
}
function WVe({ monomerId: e, areaId: o, factoryId: n }) {
  return W({ url: "api/mes/bridge/warehouse/box/print", method: "get", params: { monomerId: e, areaId: o, factoryId: n } });
}
function jVe({ monomerId: e, areaId: o, factoryId: n }) {
  return W({ url: "api/mes/bridge/warehouse/enclosure/print", method: "get", params: { monomerId: e, areaId: o, factoryId: n } });
}
function FVe(e) {
  return W({ url: "/api/mes/bridge/warehouse/report/print", method: "get", params: e });
}
function zVe(e) {
  return W({ url: "/api/mes/bridge/team_form/box_element/process/print", method: "get", params: e });
}
function BVe(e) {
  return W({ url: "/api/mes/bridge/team_form/box_element/details/print", method: "get", params: e });
}
function HVe(e) {
  return W({ url: "/api/mes/bridge/wages/reckon/print", method: "get", params: e });
}
function qVe(e) {
  return W({ url: "/api/mes/bridge/wages/reckon/details/print", method: "get", params: e });
}
function GVe(e) {
  return W({ url: "/api/mes/bridge/production_statements/print", method: "get", params: e });
}
function QVe(e) {
  return W({ url: "/api/mes/bridge/analysis/production_summary/group/print", method: "get", params: e });
}
function ZVe(e) {
  return W({ url: "/api/mes/bridge/analysis/production_summary/in_production/details/print", method: "get", params: e });
}
function JVe(e) {
  return W({ url: "/api/mes/bridge/analysis/production_summary/un_production/details/print", method: "get", params: e });
}
function XVe(e) {
  return W({ url: "/api/mes/bridge/analysis/production_summary/complete/details/print", method: "get", params: e });
}
function $Ve(e) {
  return W({ url: "/api/mes/bridge/analysis/hysteresis/details/print", method: "get", params: e });
}
function ewe(e) {
  return W({ url: "/api/mes/bridge/scheduling/print", method: "get", params: e });
}
function twe(e) {
  return W({ url: "/api/mes/bridge/task/process/product/task/list/print", method: "get", params: e });
}
function iwe(e) {
  return W({ url: "/api/mes/bridge/task/process/product/task/list/print", method: "get", params: e });
}
function awe(e) {
  return W({ url: "/api/mes/bridge/task/process/nesting/task/list/print", method: "get", params: e });
}
function lwe(e) {
  return W({ url: "/api/mes/bridge/task/order/drilling/print", method: "get", params: e });
}
function owe(e) {
  return W({ url: "/api/mes/bridge/kanban/element_matching/detail/print", method: "get", params: e });
}
