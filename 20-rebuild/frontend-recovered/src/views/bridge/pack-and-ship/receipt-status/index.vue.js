import { ref as h } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as D } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { withDirectives as G } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as T } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as o } from "vue";
import { createTextVNode as d } from "vue";
import { Fragment as Q } from "vue";
import { renderList as Y } from "vue";
import { withModifiers as S } from "vue";
import { ElNotification as O } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElPopconfirm as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { x as Z, o as ee, z as te, bA as P, aN as ae, bv as ie, bi as R, by as v, G as _, bN as le, P as oe, a as se } from "../../../../shared/runtime.js";
import { c as ne, d as re, a as ue, b as ce } from "./module/cancel-form.vue.js";
import { r as f } from "../../../../modules/bridge-86f96a4f.js";
import pe from "./module/header.vue.js";
import de from "../components/common-detail/index.vue.js";
import "../components/common-detail/module/structure.vue.js";
import "../components/common-detail/module/enclosure.vue.js";
import "../components/common-detail/module/auxiliary-material.vue.js";
const me = { class: "app-container" }, fe = { class: "project-name" }, ye = { key: 1 }, ve = { style: { width: "150px", height: "53px", overflow: "hidden", position: "absolute", top: "-18px", left: "-20px" } }, xe = { __name: "index", setup(be) {
  const I = { add: false, edit: false, del: false, download: false }, L = [["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["statusUpdateDate", ["parse-time", "{y}-{m}-{d}"]]], E = h(), V = h(false), U = h({}), g = h("detail"), { crud: y, columns: r } = Z({ title: "收货状态", sort: ["auditReceiptTime.desc"], permission: { ...f }, crudApi: { ...ne }, optShow: { ...I }, invisibleColumns: ["manufactureType", "productType"] }, E), { maxHeight: F } = ee({ paginate: true }), w = h(false), u = h({});
  function x(k, c) {
    g.value = c, u.value = k, U.value = k, w.value = true;
  }
  async function A() {
    try {
      await ce(u.value.id), O({ title: "签收成功", type: "success" }), w.value = false, y.toQuery();
    } catch (k) {
      console.log("签收失败", k);
    }
  }
  function B() {
    w.value = false, y.toQuery();
  }
  return (k, c) => {
    const s = J, m = K, N = C("common-button"), z = se, H = C("common-table"), $ = C("table-cell-tag"), M = W, q = X;
    return a(), D("div", me, [n(e(pe)), G((a(), l(H, { ref_key: "tableRef", ref: E, data: e(y).data, "data-format": L, style: { width: "100%" }, "max-height": e(F), onSortChange: e(y).handleSortChange, onSelectionChange: e(y).selectionChangeHandler }, { default: i(() => [n(s, { type: "selection", width: "55", align: "center" }), n(s, { label: "序号", type: "index", align: "center", width: "55" }), e(r).visible("project.shortName") && !e(y).query.projectId ? (a(), l(s, { key: "project.shortName", prop: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250" }, { default: i((t) => [T("span", fe, p(e(te)(t.row.project)), 1)]), _: 1 })) : o("", true), e(r).visible("manufactureType") ? (a(), l(s, { key: "manufactureType", prop: "manufactureType", "show-overflow-tooltip": true, label: "制造类型", align: "center", "min-width": "80" }, { default: i((t) => [n(m, { type: e(P).V[t.row.manufactureType].T, effect: "plain", "disable-transitions": "" }, { default: i(() => [d(p(e(P).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : o("", true), e(r).visible("productType") ? (a(), l(s, { key: "productType", prop: "productType", label: "装载类型", width: "165" }, { default: i((t) => [(a(true), D(Q, null, Y(e(ae)(e(ie).getBits(e(R), t.row.productType, "V")), (b) => (a(), l(m, { style: { "margin-right": "5px" }, key: b, type: e(R).V[b].T, effect: "light", "disable-transitions": "" }, { default: i(() => [d(p(e(R).VL[b]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : o("", true), e(r).visible("serialNumber") ? (a(), l(s, { key: "serialNumber", prop: "serialNumber", sortable: "custom", label: "车次/船次", align: "center", "min-width": "140px" }, { default: i((t) => [n(m, { effect: "light", "disable-transitions": "", style: { width: "100%", "max-width": "130px" } }, { default: i(() => [d(p(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : o("", true), e(r).visible("auditTime") ? (a(), l(s, { key: "auditTime", prop: "auditTime", align: "center", sortable: "custom", label: "发运日期", width: "120" }, { default: i((t) => [T("span", null, p(t.row.auditTime), 1)]), _: 1 })) : o("", true), e(r).visible("statusUpdateDate") ? (a(), l(s, { key: "statusUpdateDate", prop: "statusUpdateDate", sortable: "custom", label: "状态更新日期", align: "center", width: "120" }, { default: i((t) => [T("span", null, p(t.row.statusUpdateDate), 1)]), _: 1 })) : o("", true), e(r).visible("shipmentStatus") ? (a(), l(s, { key: "shipmentStatus", prop: "shipmentStatus", sortable: "custom", label: "发运状态", align: "center", "min-width": "90" }, { default: i((t) => [t.row.sourceRow.shipmentStatus ? (a(), l(m, { key: 0, type: e(v).V[t.row.shipmentStatus].T, "disable-transitions": "", effect: "plain" }, { default: i(() => [d(p(e(v).VL[t.row.shipmentStatus]), 1)]), _: 2 }, 1032, ["type"])) : (a(), D("span", ye, "-"))]), _: 1 })) : o("", true), e(r).visible("licensePlate") ? (a(), l(s, { key: "licensePlate", prop: "licensePlate", sortable: "custom", "show-overflow-tooltip": true, label: "车牌/船牌号", align: "center", "min-width": "100" })) : o("", true), e(r).visible("driverName") ? (a(), l(s, { key: "driverName", prop: "driverName", sortable: "custom", "show-overflow-tooltip": true, label: "司机姓名", align: "center", "min-width": "100" })) : o("", true), e(r).visible("driverPhone") ? (a(), l(s, { key: "driverPhone", prop: "driverPhone", "show-overflow-tooltip": true, label: "司机电话", align: "center", "min-width": "120" })) : o("", true), e(r).visible("auditUserName") ? (a(), l(s, { key: "auditUserName", prop: "auditUserName", sortable: "custom", "show-overflow-tooltip": true, label: "发运人", align: "center", "min-width": "100" })) : o("", true), e(r).visible("receiptName") ? (a(), l(s, { key: "receiptName", prop: "receiptName", sortable: "custom", "show-overflow-tooltip": true, label: "收货人", align: "center", "min-width": "100" })) : o("", true), e(r).visible("auditReceiptName") ? (a(), l(s, { key: "auditReceiptName", prop: "auditReceiptName", sortable: "custom", "show-overflow-tooltip": true, label: "实际收货人", align: "center", "min-width": "100" })) : o("", true), e(_)([...e(f).detail, ...e(f).cancelDelivery, ...e(f).confirmDelivery]) ? (a(), l(s, { key: 13, label: "操作", width: "180px", align: "center", fixed: "right" }, { default: i(({ row: { sourceRow: t } }) => {
      var b;
      return [e(_)(e(f).detail) ? (a(), l(N, { key: 0, type: "primary", icon: "el-icon-view", size: "default", onClick: S((j) => x(t, "detail"), ["stop"]) }, null, 8, ["onClick"])) : o("", true), t.shipmentStatus === e(v).DELIVERY.V && ((b = t.project) == null ? void 0 : b.businessType) === e(le).MACHINING.V && e(_)(e(f).confirmDelivery) ? (a(), l(N, { key: 1, size: "default", type: "success", onClick: S((j) => x(t, "sign"), ["stop"]) }, { default: i(() => [n(z, { "icon-class": "sign" })]), _: 2 }, 1032, ["onClick"])) : o("", true), t.shipmentStatus === e(v).DELIVERY.V && e(_)(e(f).cancelDelivery) ? (a(), l(N, { key: 2, type: "warning", size: "default", onClick: S((j) => x(t, "cancel"), ["stop"]) }, { default: i(() => [n(z, { "icon-class": "delivery-cancel", style: { "font-size": "14px" } })]), _: 2 }, 1032, ["onClick"])) : o("", true)];
    }), _: 1 })) : o("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange", "onSelectionChange"])), [[q, e(y).loading]]), n(e(oe)), n(e(de), { visible: w.value, "onUpdate:visible": c[1] || (c[1] = (t) => w.value = t), "detail-info": u.value, title: g.value === "detail" ? "装车详情" : g.value === "cancel" ? "取消送货" : "到场签收", detailFunc: e(re) }, { tip: i(() => [T("div", ve, [n($, { show: u.value.shipmentStatus === e(v).RETURN.V, name: "已取消", color: "#f56c6c" }, null, 8, ["show"])]), u.value.shipmentStatus ? (a(), l(m, { key: 0, effect: "plain", size: "large", type: e(v).V[u.value.shipmentStatus].T }, { default: i(() => [d(p(e(v).VL[u.value.shipmentStatus]), 1)]), _: 1 }, 8, ["type"])) : o("", true), n(m, { effect: "plain", size: "large", style: { "margin-left": "5px" }, type: "danger" }, { default: i(() => [d("车次/船次：" + p(u.value.serialNumber), 1)]), _: 1 }), n(m, { effect: "plain", size: "large" }, { default: i(() => [d("项目：" + p(u.value.project && u.value.project.shortName), 1)]), _: 1 }), n(m, { effect: "plain", size: "large", type: "success" }, { default: i(() => [d("发运人：" + p(u.value.auditUserName), 1)]), _: 1 }), n(m, { effect: "plain", size: "large", type: "success" }, { default: i(() => [d("收货人：" + p(u.value.receiptName), 1)]), _: 1 })]), titleRight: i(() => [g.value === "cancel" && e(_)(e(f).cancelDelivery) ? (a(), l(N, { key: 0, type: "warning", size: "default", onClick: c[0] || (c[0] = S((t) => V.value = true, ["stop"])) }, { default: i(() => c[3] || (c[3] = [d("取消送货")])), _: 1, __: [3] })) : o("", true), g.value === "sign" && e(_)(e(f).confirmDelivery) ? (a(), l(M, { key: 1, title: "确定签收吗?", onConfirm: A }, { reference: i(() => [n(N, { type: "success", size: "default" }, { default: i(() => c[4] || (c[4] = [d("确认签收")])), _: 1, __: [4] })]), _: 1 })) : o("", true)]), _: 1 }, 8, ["visible", "detail-info", "title", "detailFunc"]), n(e(ue), { modelValue: V.value, "onUpdate:modelValue": c[2] || (c[2] = (t) => V.value = t), detailInfo: U.value, onSuccess: B }, null, 8, ["modelValue", "detailInfo"])]);
  };
} };
export {
  xe as default
};
