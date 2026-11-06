function nwe(e) {
  return W({ url: "/api/mes/bridge/kanban/element_matching/area/product/print", method: "get", params: e });
}
function swe(e) {
  return W({ url: "/api/mes/bridge/kanban/painting/print", method: "get", params: e });
}
function rwe(e) {
  return W({ url: "/api/mes/bridge/kanban/form/box/print", method: "get", params: e });
}
function uwe(e) {
  return W({ url: "/api/mes/bridge/kanban/form/enclosure/print", method: "get", params: e });
}
function cwe(e) {
  return W({ url: "/api/mes/bridge/report/inspection/summary/review/print", method: "get", params: e });
}
function dwe(e) {
  return W({ url: "/api/mes/bridge/scheduling/area/listBox/print", method: "get", params: e });
}
function mwe(e) {
  return W({ url: "/api/mes/bridge/scheduling/area/listElement/print", method: "get", params: e });
}
function pwe(e) {
  return W({ url: "/api/mes/bridge/scheduling/area/listMachinePart/print", method: "get", params: e });
}
function hwe(e) {
  return W({ url: "/api/mes/bridge/cargo/project/cargoList/details/print", method: "get", params: e });
}
function fwe(e) {
  return W({ url: "/api/mes/bridge/cargo/project/cargoList/directShipment/details/print", method: "get", params: e });
}
function gwe(e) {
  return W({ url: "/api/mes/bridge/workshop/report/box/summary/print", method: "get", params: e });
}
function Ewe(e) {
  return W({ url: "/api/mes/bridge/task/process/product/print", method: "get", params: e });
}
function ywe(e) {
  return W({ url: "/api/mes/bridge/task/tracking/month/project/print", method: "get", params: e });
}
function Twe(e) {
  return W({ url: "/api/mes/bridge/task/tracking/productionLine/detail/print", method: "get", params: e });
}
function _we(e) {
  return W({ url: "/api/mes/bridge/task/process/dull/process/detail/print", method: "get", params: e });
}
function bwe(e) {
  return W({ url: "/api/mes/bridge/kanban/project/process/summary/detail/print", method: "get", params: e });
}
function Vwe(e) {
  return W({ url: "/api/mes/bridge/warehouse/finish-product/print", method: "get", params: e });
}
function wwe(e) {
  return W({ url: "/api/mes/bridge/warehouse/finish-product/detail/print", method: "get", params: e });
}
function Swe(e) {
  return W({ url: "/api/mes/bridge/warehouse/finish-product/detail/print", method: "get", params: e });
}
function vwe(e) {
  return W({ url: "/api/bridge/tech-box/list-summary/print", method: "get", params: e });
}
function Rwe(e) {
  return W({ url: "/api/bridge/tech-element/list-summary/print", method: "get", params: e });
}
function Mwe(e) {
  return W({ url: "/api/bridge/tech-machinePart/list-summary/print", method: "get", params: e });
}
const Ti = { machinePartDetail: owe, machinePartList: nwe, paintingList: swe, structureProjectSummary: rwe, enclosureProjectSummary: uwe, projectOverviewList: bwe, schedulingDetail: ewe, productionTaskOrder: twe, assembleNestingOrder: awe, assembleProductionTaskOrder: iwe, drillProductionTaskOrder: lwe, productionReport: GVe, productionStatistics: QVe, productionStatisticsIn: ZVe, productionStatisticsUn: JVe, productionStatisticsComplete: XVe, unfinishedList: $Ve, qhseProductionLineReport: cwe, structureProductionLine: zVe, structureProcess: BVe, teamWage: HVe, teamWageDetail: qVe, packingList: OVe, shipmentSummary: kVe, shipmentDetail: DVe, receiptStatusSummary: xVe, shippingList: UVe, shipmentAudit: YVe, logisticsSummary: KVe, warehouseStateStructure: WVe, warehouseStateEnclosure: jVe, warehouseStateReport: FVe, boxClassList: dwe, elementClassList: mwe, machinePartClassList: pwe, bridgeProjectShipDetail: hwe, bridgeProjectShipDetailDirect: fwe, factoryWorkshopReport: gwe, workOrderTrackingList: Ewe, monthlyTaskList: ywe, productionLineList: Twe, processList: _we, productSendReceiveStorage: Vwe, productSendReceiveStorageDetail: wwe, structureFinishedGoodsInventoryDetail: Swe, boxSummary: vwe, cellSummary: Rwe, partSummary: Mwe };
function Awe(e) {
  return W({ url: `api/wms/inbound/receipt/${e}/print`, method: "get" });
}
function Nwe(e) {
  return W({ url: `api/wms/outbound/receipt/${e}/print`, method: "get" });
}
function Lwe(e) {
  return W({ url: `/api/v2/wms/inbound/manufactured/receipt/${e}/print`, method: "get" });
}
function Iwe(e) {
  return W({ url: `api/v2/wms/outbound/manufactured/receipt/${e}/print`, method: "get" });
}
function Cwe(e) {
  return W({ url: `api/wms/return/receipt/${e}/print`, method: "get" });
}
function Pwe(e) {
  return W({ url: `api/wms/reject/receipt/${e}/print`, method: "get" });
}
function Owe(e) {
  return W({ url: `api/wms/transfer/receipt/${e}/print`, method: "get" });
}
function kwe(e) {
  return W({ url: `api/wms/move-material/${e}/print`, method: "get" });
}
function Dwe(e) {
  return W({ url: "api/wms/move-material/details/print", method: "post", data: e });
}
function xwe(e) {
  return W({ url: "api/wms/supplement/print", method: "get", params: e });
}
function Uwe(e) {
  return W({ module: "wms", url: "report/wasteSale/print", method: "get", params: e });
}
function Ywe(e) {
  return W({ url: `api/wms/report/raw-materials/outbound/receiptDetailById/${e}/print`, method: "get" });
}
function Kwe(e) {
  return W({ url: `api/wms/report/raw-materials/return/receiptDetailById/${e}/print`, method: "get" });
}
function Wwe(e) {
  return W({ url: `api/wms/report/raw-materials/transfer/receiptDetailById/${e}/print`, method: "get" });
}
const io = { manufRmInboundReceipt: Lwe, wmsRmInboundReceipt: Awe, wmsRmOutboundReceipt: Nwe, wmsRmManufOutboundReceipt: Iwe, wmsRmReturnReceipt: Cwe, wmsRmRejectReceipt: Pwe, wmsRmTransferReceipt: Owe, wmsRmMoveMaterialReceipt: kwe, wmsRmMoveMaterialDetails: Dwe, wmsRmSupplementReceipt: xwe, wmsScrapSell: Uwe, wmsRmOutboundReceiptReport: Ywe, wmsRmReturnReceiptReport: Kwe, wmsRmTransferReceiptReport: Wwe };
function jwe(e) {
  return W({ module: "contract", url: "contract/receive-invoice/list/print", method: "get", params: e });
}
function Fwe(e) {
  return W({ module: "contract", url: "supply-chain/order-payment/listInbound/print", method: "get", params: e });
}
function zwe(e) {
  return W({ module: "contract", url: "contract/payment/list/print", method: "get", params: e });
}
function Bwe(e) {
  return W({ module: "contract", url: "supply-chain/order-payment/print", method: "get", params: e });
}
function Hwe(e) {
  return W({ module: "contract", url: "supply-chain/order-payment/sumBySupplier/print", method: "get", params: e });
}
function qwe(e) {
  return W({ module: "contract", url: "supply-chain/logistics/record/print", method: "get", params: e });
}
function Gwe(e) {
  return W({ module: "scm", url: `apply-purchase/${e}/print`, method: "get" });
}
function Qwe(e) {
  return W({ module: "scm", url: `apply-purchase/${e}/print`, method: "get" });
}
function Zwe(e) {
  return W({ url: "/api/v2/scm/purchase-order/print", method: "post", data: e });
}
function Jwe(e) {
  return e != null && e.isPurchase ? W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/inboundDetail/${e.id}/download`, method: "get", params: e }) : e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/inboundList/download", method: "get", params: e }) : W({ url: `/api/v2/supply-chain/order-payment/orderDetail/${e.orderId}/download`, method: "get" });
}
function Xwe(e) {
  return e != null && e.isPurchase ? W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/inboundDetail/${e.id}/download`, method: "get", params: e }) : e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/inboundList/download", method: "get", params: e }) : W({ url: `/api/v2/supply-chain/order-payment/orderDetail/${e.orderId}/download`, method: "get" });
}
function $we(e) {
  return e != null && e.isPurchase ? W({ url: `/api/v2/scm/purchase-order/getPurchaseOrder/inboundDetail/${e.id}/download`, method: "get", params: e }) : e != null && e.isContract ? W({ url: "/api/project/v2/projectLedger/supplierLedger/inboundList/download", method: "get", params: e }) : W({ url: `/api/v2/supply-chain/order-payment/orderDetail/${e.orderId}/download`, method: "get" });
}
