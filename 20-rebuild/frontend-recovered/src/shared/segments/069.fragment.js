function eSe(e) {
  return W({ url: "/api/project/v2/projectLedger/supplierLedger/preSettleList/print", method: "get", params: e });
}
function tSe(e) {
  return W({ url: "/api/v2/wms/report/raw-materials/purchaseOrderDetail/print", method: "get", params: e });
}
function iSe(e) {
  return W({ url: "/api/v2/supply-chain/order-payment/print/orderReconciliationDetailAll", method: "get", params: e });
}
const Nl = { invoiceDetail: jwe, paymentRecord: zwe, inboundRecord: Fwe, orderPaymentLedger: Bwe, supplierPaymentLedger: Hwe, logisticsRecord: qwe, requisitionsDetail: Gwe, storageDetails: Jwe, newStorageDetails: Xwe, newManufacturedStorageDetails: $we, preSettlementDetail: eSe, manufRequisitionsDetail: Qwe, purchaseDetail: Zwe, purchaseShippingList: tSe, purchaseDetailDimensions: iSe };
function aSe(e) {
  return W({ module: "project", url: `receiving/listProductUp/${e.cargoListId}/print`, method: "get", params: e });
}
function lSe(e) {
  return W({ module: "project", url: `receiving/listCanReceiveProduct/${e.cargoListId}/print`, method: "get", params: e });
}
function oSe(e) {
  return W({ module: "project", url: "receiving/receiving-statement/printV2", method: "get", params: e });
}
function nSe(e) {
  return W({ module: "project", url: "receiving/receiving-statement/printV2", method: "get", params: e });
}
function sSe(e) {
  return W({ module: "project", url: "receiving/receiving-install-statement/print", method: "get", params: e });
}
function rSe(e) {
  return W({ module: "project", url: "install-report/install-statement/print", method: "get", params: e });
}
function uSe(e) {
  return W({ module: "plan", url: "planDetail/areaArtifactComplete/detail/print", method: "get", params: e });
}
function cSe(e) {
  return W({ module: "plan", url: "planDetail/enclosureComplete/detail/print", method: "get", params: e });
}
function dSe(e) {
  return W({ module: "plan", url: "planDetail/areaArtifact/detail/print", method: "get", params: e });
}
function mSe(e) {
  return W({ module: "plan", url: "planDetail/areaEnclosure/detail/print", method: "get", params: e });
}
function pSe(e) {
  return W({ module: "project", url: `receiving/operateDetails/${e}/print`, method: "get" });
}
function hSe(e) {
  return W({ module: "project", url: "receiving/received/print", method: "get", params: e });
}
function fSe(e) {
  return W({ module: "project", url: "receiving/received/print", method: "get", params: e });
}
function gSe(e) {
  return W({ module: "project", url: "reject/detail/print", method: "get", params: e });
}
function ESe(e) {
  return W({ module: "project", url: "install-plan/getLaborOrderDetailsPage/print", method: "get", params: e });
}
function ySe(e) {
  return W({ module: "project", url: "install-report/supplierInstall/Details/print", method: "get", params: e });
}
function TSe(e) {
  return W({ module: "project", url: "install-report/projectInstall/Details/print", method: "get", params: e });
}
const Ll = { deliveryCargoList: aSe, deliveryPartCargoList: lSe, deliveryReportList: oSe, deliveryOutReportList: nSe, deliveryInstallList: sSe, installReportList: rSe, productProcessList: uSe, productEnclosureProcessList: cSe, deepenProcessList: dSe, deepenEnclosureProcessList: mSe, outsourcingReceivingRecord: pSe, receivingRecord: hSe, outReceivingRecord: fSe, outsourcingReturnRecord: gSe, laborSettingList: ESe, laborInstallList: ySe, projectInstallList: TSe };
function _Se(e) {
  return W({ module: "plan", url: "auxiliaryPart/summary/print", method: "get", params: e });
}
function bSe({ projectId: e, monomerId: o, areaId: n }) {
  return W({ module: "plan", url: `project-execution-dynamics/scheduling-detail/product/print/${e}`, method: "get", params: { monomerId: o, areaId: n } });
}
function VSe({ projectId: e, monomerId: o, areaId: n }) {
  return W({ module: "plan", url: `project-execution-dynamics/produced-detail/product/print/${e}`, method: "get", params: { monomerId: o, areaId: n } });
}
function wSe({ projectId: e, monomerId: o, areaId: n }) {
  return W({ module: "plan", url: `project-execution-dynamics/not-produced-detail/product/print/${e}`, method: "get", params: { monomerId: o, areaId: n } });
}
function SSe({ projectId: e, monomerId: o, areaId: n }) {
  return W({ module: "plan", url: `project-execution-dynamics/delivery-detail/product/print/${e}`, method: "get", params: { monomerId: o, areaId: n } });
}
const Mu = { auxiliaryMaterialSummary: _Se, schedulingDetailPrint: bSe, producedDetailPrint: VSe, notProducedDetailPrint: wSe, deliveryDetailPrint: SSe };
function vSe(e) {
  return W({ url: "/api/mes/enclosure/order/order/detail/print", method: "get", params: e });
}
function RSe(e) {
  return W({ url: "/api/mes/enclosure/produce/v2/order/detail/print", method: "get", params: e });
}
function MSe(e) {
  return W({ url: "/api/mes/enclosure/produce/overview/v2/order/detail/print", method: "get", params: e });
}
function ASe(e) {
  return W({ url: "/api/mes/enclosure/produce/overview/order/team/produce/print", method: "get", params: e });
}
function NSe(e) {
  return W({ url: "/api/mes/enclosure/produce/overview/order/team/produce/detail/print", method: "get", params: e });
}
const Au = { schedulingWorkOrderDetail: vSe, taskTrackingDetail: RSe, productionStatistics: MSe, teamProduction: ASe, teamProductionDetail: NSe };
function LSe(e) {
  return W({ url: "/api/crm/data/center/business/print/custom", method: "get", params: e });
}
function ISe(e) {
  return W({ url: "/api/crm/data/center/get/info/by/informant/user/print/custom", method: "get", params: e });
}
function CSe(e) {
  return W({ url: "/api/crm/data/center/new/project/print", method: "get", params: e });
}
function PSe(e) {
  return W({ url: "/api/crm/enterprise/warehousing/list/down/load", method: "get", params: e });
}
function OSe(e) {
  return W({ url: "/api/crm/project/information/warehousing/list/down/load", method: "get", params: e });
}
function kSe(e) {
  return W({ url: "/api/crm/government/warehousing/list/down/load", method: "get", params: e });
}
function DSe(e) {
  return W({ url: "/api/crm/bidding/platform/warehousing/list/down/load", method: "get", params: e });
}
function xSe(e) {
  return W({ url: "/api/crm/supplier/warehousing/list/down/load", method: "get", params: e });
}
function USe(e) {
  return W({ url: "/api/crm/business/center/enterprise/list/down/load", method: "get", params: e });
}
function YSe(e) {
  return W({ url: "/api/crm/business/center/supplier/list/down/load", method: "get", params: e });
}
function KSe(e) {
  return W({ url: "/api/crm/business/center/government/list/down/load", method: "get", params: e });
}
function WSe(e) {
  return W({ url: "/api/crm/business/center/platform/list/down/load", method: "get", params: e });
}
function jSe(e) {
  return W({ url: "/api/crm/business/center/project/list/down/load", method: "get", params: e });
}
function FSe(e) {
  return W({ url: "/api/crm/bidding/center/list/down/load/custom", method: "get", params: e });
}
function zSe(e) {
  return W({ url: "/api/crm/bidding/center/list/down/load/custom", method: "get", params: e });
}
function BSe(e) {
  return W({ url: "/api/crm/bidding/center/list/down/load/custom", method: "get", params: e });
}
