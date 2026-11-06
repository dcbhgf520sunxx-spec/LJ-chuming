import { ref as _ } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as fe } from "vue";
import { createBlock as i } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as V } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as s } from "vue";
import { createTextVNode as d } from "vue";
import { Fragment as R } from "vue";
import { renderList as G } from "vue";
import { withModifiers as I } from "vue";
import { ElNotification as ye } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { ElTag as _e } from "element-plus";
import { ElPopconfirm as be } from "element-plus";
import { InfoFilled as he } from "@element-plus/icons-vue";
import { ElIcon as ge } from "element-plus";
import { ElTooltip as we } from "element-plus";
import { ElFormItem as Te } from "element-plus";
import { ElForm as ke } from "element-plus";
import { vLoading as Ne } from "element-plus";
import { _ as Ve, m as Se, x as xe, o as Ce, z as Ee, bA as M, K as O, aN as Q, bv as K, bi as U, bw as P, by as w, G as T, bN as je, P as De, iy as Re, L as Ie, S as Ue, a as Pe } from "../../../../shared/runtime.js";
import { g as ze, d as Le, a as Ae } from "../../../../modules/receipt-status-4b335dc2.js";
import { r as b } from "../../../../modules/ship-manage-3066b2ed.js";
import Fe from "./module/header.vue.js";
import $e from "../components/common-detail/index.vue.js";
import Be from "./module/cancel-form.vue.js";
import { _ as qe } from "../../../../modules/UploadBtn-b4cfb47a.js";
import "../components/common-detail/module/structure.vue.js";
import "../components/common-detail/module/part.vue.js";
import "../components/common-detail/module/enclosure.vue.js";
import "../components/common-detail/module/auxiliary-material.vue.js";
import "../components/common-detail/module/box.vue.js";
const He = { class: "app-container" }, Ge = { class: "project-name" }, Me = { key: 1 }, Oe = { style: { width: "150px", height: "53px", overflow: "hidden", position: "absolute", top: "-18px", left: "-20px" } }, Qe = { key: 1 }, Ke = { __name: "index", setup(Ye) {
  const Y = { add: false, edit: false, del: false, download: false }, J = [["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["statusUpdateDate", ["parse-time", "{y}-{m}-{d}"]]], { currentProjectType: W } = Se(["currentProjectType"]), z = _(), E = _(false), L = _({}), h = _("detail"), j = _([]), { crud: m, CRUD: X, columns: u } = xe({ title: "收货状态", sort: ["auditReceiptTime.desc"], permission: { ...b }, crudApi: { get: ze }, optShow: { ...Y }, invisibleColumns: ["manufactureType", "productType"] }, z), { maxHeight: Z } = Ce({ paginate: true }), k = _(false), f = _({}), N = _({}), A = _(), S = _(false);
  function F(v, o) {
    h.value = o, f.value = v, L.value = v, k.value = true;
  }
  async function ee() {
    var v, o;
    try {
      const n = ((o = (v = j.value) == null ? void 0 : v.map((y) => y.id)) == null ? void 0 : o[0]) || void 0;
      await Ae(f.value.id, { attachmentId: n }), ye({ title: "签收成功", type: "success" }), k.value = false, m.toQuery();
    } catch (n) {
      console.log("签收失败", n);
    }
  }
  function te(v, o) {
    N.value = o;
  }
  function ae(v) {
    A.value = v.id, S.value = true;
  }
  X.HOOK.beforeToQuery = () => {
    m.query.projectType = W.value;
  };
  function le() {
    k.value = false, m.toQuery();
  }
  return (v, o) => {
    const n = ve, y = _e, x = D("common-button"), ie = Pe, oe = D("common-table"), se = D("table-cell-tag"), ne = be, re = he, ue = ge, pe = we, ce = Te, de = ke, me = Ne;
    return a(), g("div", He, [r(e(Fe)), fe((a(), i(oe, { ref_key: "tableRef", ref: z, data: e(m).data, "data-format": J, "max-height": e(Z), style: { width: "100%" }, onSortChange: e(m).handleSortChange, onSelectionChange: e(m).selectionChangeHandler }, { default: l(() => [r(n, { align: "center", type: "selection", width: "55" }), r(n, { align: "center", label: "序号", type: "index", width: "55" }), e(u).visible("project.shortName") && !e(m).query.projectId ? (a(), i(n, { key: "project.shortName", "show-overflow-tooltip": true, label: "项目", "min-width": "250", prop: "project.shortName" }, { default: l((t) => [V("span", Ge, p(e(Ee)(t.row.project)), 1)]), _: 1 })) : s("", true), e(u).visible("manufactureType") ? (a(), i(n, { key: "manufactureType", "show-overflow-tooltip": true, align: "center", label: "制造类型", "min-width": "80", prop: "manufactureType" }, { default: l((t) => [r(y, { type: e(M).V[t.row.manufactureType].T, "disable-transitions": "", effect: "plain" }, { default: l(() => [d(p(e(M).VL[t.row.manufactureType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : s("", true), e(u).visible("productType") && e(m).query.projectType === e(O).STEEL.V ? (a(), i(n, { key: "productType", label: "装载类型", prop: "productType", width: "165" }, { default: l((t) => [(a(true), g(R, null, G(e(Q)(e(K).getBits(e(U), t.row.productType, "V")), (c) => (a(), i(y, { key: c, type: e(U).V[c].T, "disable-transitions": "", effect: "light", style: { "margin-right": "5px" } }, { default: l(() => [d(p(e(U).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : s("", true), e(u).visible("productType") && e(m).query.projectType === e(O).BRIDGE.V ? (a(), i(n, { key: "productType", label: "装载类型", prop: "productType", width: "165" }, { default: l((t) => [(a(true), g(R, null, G(e(Q)(e(K).getBits(e(P), t.row.productType, "V")), (c) => (a(), i(y, { key: c, type: e(P).V[c].T, "disable-transitions": "", effect: "light", style: { "margin-right": "5px" } }, { default: l(() => [d(p(e(P).VL[c]), 1)]), _: 2 }, 1032, ["type"]))), 128))]), _: 1 })) : s("", true), e(u).visible("serialNumber") ? (a(), i(n, { key: "serialNumber", align: "center", label: "车次/船次", "min-width": "140px", prop: "serialNumber", sortable: "custom" }, { default: l((t) => [r(y, { "disable-transitions": "", effect: "light", style: { width: "100%", "max-width": "130px" } }, { default: l(() => [d(p(t.row.serialNumber), 1)]), _: 2 }, 1024)]), _: 1 })) : s("", true), e(u).visible("auditTime") ? (a(), i(n, { key: "auditTime", align: "center", label: "发运日期", prop: "auditTime", sortable: "custom", width: "120" }, { default: l((t) => [V("span", null, p(t.row.auditTime), 1)]), _: 1 })) : s("", true), e(u).visible("statusUpdateDate") ? (a(), i(n, { key: "statusUpdateDate", align: "center", label: "状态更新日期", prop: "statusUpdateDate", sortable: "custom", width: "120" }, { default: l((t) => [V("span", null, p(t.row.statusUpdateDate), 1)]), _: 1 })) : s("", true), e(u).visible("shipmentStatus") ? (a(), i(n, { key: "shipmentStatus", align: "center", label: "发运状态", "min-width": "90", prop: "shipmentStatus", sortable: "custom" }, { default: l((t) => [t.row.sourceRow.shipmentStatus ? (a(), i(y, { key: 0, type: e(w).V[t.row.shipmentStatus].T, "disable-transitions": "", effect: "plain" }, { default: l(() => [d(p(e(w).VL[t.row.shipmentStatus]), 1)]), _: 2 }, 1032, ["type"])) : (a(), g("span", Me, "-"))]), _: 1 })) : s("", true), e(u).visible("licensePlate") ? (a(), i(n, { key: "licensePlate", "show-overflow-tooltip": true, align: "center", label: "车牌/船牌号", "min-width": "100", prop: "licensePlate", sortable: "custom" })) : s("", true), e(u).visible("driverName") ? (a(), i(n, { key: "driverName", "show-overflow-tooltip": true, align: "center", label: "司机姓名", "min-width": "100", prop: "driverName", sortable: "custom" })) : s("", true), e(u).visible("driverPhone") ? (a(), i(n, { key: "driverPhone", "show-overflow-tooltip": true, align: "center", label: "司机电话", "min-width": "120", prop: "driverPhone" })) : s("", true), e(u).visible("auditUserName") ? (a(), i(n, { key: "auditUserName", "show-overflow-tooltip": true, align: "center", label: "发运人", "min-width": "100", prop: "auditUserName", sortable: "custom" })) : s("", true), e(u).visible("receiptName") ? (a(), i(n, { key: "receiptName", "show-overflow-tooltip": true, align: "center", label: "收货人", "min-width": "100", prop: "receiptName", sortable: "custom" })) : s("", true), e(u).visible("auditReceiptName") ? (a(), i(n, { key: "auditReceiptName", "show-overflow-tooltip": true, align: "center", label: "实际收货人", "min-width": "100", prop: "auditReceiptName", sortable: "custom" })) : s("", true), e(T)([...e(b).detail, ...e(b).confirmDelivery]) ? (a(), i(n, { key: 14, align: "center", fixed: "right", label: "操作", width: "120px" }, { default: l(({ row: { sourceRow: t } }) => {
      var c;
      return [e(T)(e(b).detail) ? (a(), i(x, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: I((C) => F(t, "detail"), ["stop"]) }, null, 8, ["onClick"])) : s("", true), t.shipmentStatus === e(w).DELIVERY.V && ((c = t.project) == null ? void 0 : c.businessType) === e(je).MACHINING.V && e(T)(e(b).confirmDelivery) ? (a(), i(x, { key: 1, size: "default", type: "success", onClick: I((C) => F(t, "sign"), ["stop"]) }, { default: l(() => [r(ie, { "icon-class": "sign" })]), _: 2 }, 1032, ["onClick"])) : s("", true)];
    }), _: 1 })) : s("", true)]), _: 1 }, 8, ["data", "max-height", "onSortChange", "onSelectionChange"])), [[me, e(m).loading]]), r(e(De)), r(e(Be), { modelValue: E.value, "onUpdate:modelValue": o[0] || (o[0] = (t) => E.value = t), detailInfo: L.value, projectType: e(m).query.projectType, onSuccess: le }, null, 8, ["modelValue", "detailInfo", "projectType"]), S.value ? (a(), i(e(Re), { key: 0, isVisible: S.value, showType: "attachment", id: A.value, onClose: o[1] || (o[1] = (t) => S.value = false) }, null, 8, ["isVisible", "id"])) : s("", true), r(e($e), { visible: k.value, "onUpdate:visible": o[5] || (o[5] = (t) => k.value = t), "detail-info": f.value, detailFunc: e(Le), projectType: e(m).query.projectType, title: h.value === "detail" ? "装车详情" : h.value === "cancel" ? "取消送货" : "到场签收", onGetDetail: te }, { tip: l(() => [V("div", Oe, [r(se, { show: f.value.shipmentStatus === e(w).RETURN.V, color: "#f56c6c", name: "已取消" }, null, 8, ["show"])]), f.value.shipmentStatus ? (a(), i(y, { key: 0, type: e(w).V[f.value.shipmentStatus].T, effect: "plain", size: "large" }, { default: l(() => [d(p(e(w).VL[f.value.shipmentStatus]), 1)]), _: 1 }, 8, ["type"])) : s("", true), r(y, { effect: "plain", size: "large", style: { "margin-left": "5px" }, type: "danger" }, { default: l(() => [d("车次/船次：" + p(f.value.serialNumber), 1)]), _: 1 }), r(y, { effect: "plain", size: "large" }, { default: l(() => [d("项目：" + p(f.value.project && f.value.project.shortName), 1)]), _: 1 }), r(y, { effect: "plain", size: "large", type: "success" }, { default: l(() => [d("发运人：" + p(f.value.auditUserName), 1)]), _: 1 }), r(y, { effect: "plain", size: "large", type: "success" }, { default: l(() => [d("收货人：" + p(f.value.receiptName), 1)]), _: 1 })]), titleRight: l(() => [h.value === "cancel" && e(T)(e(b).cancelDelivery) ? (a(), i(x, { key: 0, size: "default", type: "warning", onClick: o[2] || (o[2] = I((t) => E.value = true, ["stop"])) }, { default: l(() => o[6] || (o[6] = [d("取消送货 ")])), _: 1, __: [6] })) : s("", true), h.value === "sign" && e(T)(e(b).confirmDelivery) ? (a(), i(ne, { key: 1, title: "确定签收吗?", onConfirm: ee }, { reference: l(() => [r(x, { size: "default", type: "success" }, { default: l(() => o[7] || (o[7] = [d("确认签收")])), _: 1, __: [7] })]), _: 1 })) : s("", true)]), upload: l(() => [r(de, { ref: "formRef", model: v.form, size: "default", "label-width": "90px", "label-position": "left", class: "form-style" }, { default: l(() => [r(ce, { label: "附件" }, { label: l(() => [o[8] || (o[8] = d(" 附 件： ")), r(pe, { effect: "light", content: "双击可预览附件", placement: "top" }, { default: l(() => [r(ue, null, { default: l(() => [r(re)]), _: 1 })]), _: 1 })]), default: l(() => {
      var t, c, C, $, B;
      return [(t = N.value) != null && t.receiveAttachment ? (a(), g(R, { key: 0 }, [V("div", { style: { cursor: "pointer" }, onDblclick: o[3] || (o[3] = (q) => {
        var H;
        return ae((H = N.value) == null ? void 0 : H.receiveAttachment);
      }) }, p((C = (c = N.value) == null ? void 0 : c.receiveAttachment) == null ? void 0 : C.name), 33), r(e(Ie), { params: { id: (B = ($ = N.value) == null ? void 0 : $.receiveAttachment) == null ? void 0 : B.id }, style: { "margin-left": "10px" } }, null, 8, ["params"])], 64)) : h.value !== "sign" ? (a(), g("span", Qe, "-")) : s("", true), h.value === "sign" && e(T)(e(b).confirmDelivery) ? (a(), i(e(qe), { key: 2, ref: "uploadRef", class: "upload-style", btnName: "上传附件", files: j.value, "onUpdate:files": o[4] || (o[4] = (q) => j.value = q), "file-classify": e(Ue).CONTRACT_ATT.V, sizeLimit: 5, limit: 1 }, null, 8, ["files", "file-classify"])) : s("", true)];
    }), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["visible", "detail-info", "detailFunc", "projectType", "title"])]);
  };
} }, ut = Ve(Ke, [["__scopeId", "data-v-db41f651"]]);
export {
  ut as default
};
