import { ref as p } from "vue";
import { inject as ce } from "vue";
import { computed as de } from "vue";
import { resolveComponent as b } from "vue";
import { resolveDirective as me } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { createSlots as pe } from "vue";
import { unref as n } from "vue";
import { withCtx as e } from "vue";
import { withDirectives as h } from "vue";
import { createTextVNode as i } from "vue";
import { createVNode as t } from "vue";
import { toDisplayString as r } from "vue";
import { createElementBlock as x } from "vue";
import { Fragment as D } from "vue";
import { renderList as M } from "vue";
import { createCommentVNode as k } from "vue";
import { createElementVNode as A } from "vue";
import { withModifiers as fe } from "vue";
import { isRef as ye } from "vue";
import { ElMessageBox as be } from "element-plus";
import { ElNotification as G } from "element-plus";
import { ElDescriptionsItem as _e } from "element-plus";
import { ElDescriptions as ge } from "element-plus";
import { ElTableColumn as ve } from "element-plus";
import { ElTag as we } from "element-plus";
import { ElImage as Ee } from "element-plus";
import { ElFormItem as he } from "element-plus";
import { ElForm as Ie } from "element-plus";
import { vLoading as Te } from "element-plus";
import { c as Ve } from "../../../../../modules/receipt-status-4b335dc2.js";
import { d as Re } from "../../../../../modules/ship-list-822ce00f.js";
import { _ as Le, um as _, u as Ne, o as xe, ul as De, bx as ke, K as H, z as Se, p as Ue, bw as P, bi as Be, bs as je, D as Ce, ba as Oe } from "../../../../../shared/runtime.js";
import ze from "./cancel-form.vue.js";
const Fe = { class: "imgs-box" }, Me = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailInfo: { type: Object, required: true }, projectType: { type: Number } }, emits: ["update:visible", "refresh"], setup(o, { emit: q }) {
  const S = p(), g = p(false), U = p(), v = p({ cargoListReceiptTypeEnum: _.NO_RESERVED_LOADING.V }), I = q, f = o, { visible: T, handleClose: V } = Ne({ emit: I, props: f, field: "visible", showHook: W }), { maxHeight: Q } = xe({ extraBox: [".el-drawer__header", ".other-content-top", ".other-content-bottom"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, () => S.value.loaded), B = ce("permission"), w = p(false), $ = p({}), j = p([]), R = p(false), K = de(() => f.detailInfo && f.detailInfo.id || void 0);
  function W() {
    Z();
  }
  const J = { cargoListReceiptTypeEnum: [{ required: true, message: "请选择类型", trigger: "blur" }] };
  function X() {
    v.value.cargoListReceiptTypeEnum = _.NO_RESERVED_LOADING.V, g.value = true;
  }
  async function Y() {
    var l;
    if (await U.value.validate()) {
      if (v.value.cargoListReceiptTypeEnum === _.NO_RESERVED_LOADING.V) R.value = true;
      else if (v.value.cargoListReceiptTypeEnum === _.RESERVED_LOADING.V) {
        await be.confirm("取消发运车辆回到装车状态（保留装车信息），是否确定？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
        try {
          await Ve({ id: (l = f.detailInfo) == null ? void 0 : l.id, cargoListReceiptTypeEnum: _.RESERVED_LOADING.V }), G({ title: "取消送货成功", type: "success" }), I("success"), g.value = false, V();
        } catch {
          G({ title: "取消送货失败", type: "error" });
        }
      }
    }
  }
  async function Z() {
    try {
      w.value = true;
      const l = await Re(K.value);
      $.value = l, j.value = l.detailsList;
    } catch (y) {
      console.log("详情", y);
    } finally {
      w.value = false;
    }
  }
  function ee() {
    V(), g.value = false, I("refresh");
  }
  function te(y) {
    return Oe(y, { props: ["shipQuantity"] });
  }
  return (y, l) => {
    const C = b("print-table"), L = b("common-button"), s = _e, O = ge, c = ve, z = we, ae = b("table-cell-tag"), le = b("common-table"), oe = Ee, ie = b("common-radio"), ne = he, re = Ie, se = b("common-dialog"), ue = b("common-drawer"), F = me("permission"), N = Te;
    return u(), d(ue, { ref_key: "drawerRef", ref: S, title: "装车清单", modelValue: n(T), "onUpdate:modelValue": l[4] || (l[4] = (a) => ye(T) ? T.value = a : null), direction: "rtl", "before-close": n(V), size: "80%" }, pe({ titleAfter: e(() => [h(t(C, { "api-key": (f.projectType === n(H).BRIDGE.V, "mesShipmentDetail"), params: o.detailInfo.id, size: "mini", type: "warning" }, null, 8, ["api-key", "params"]), [[F, n(B).detailPrint]])]), content: e(() => [h((u(), d(O, { class: "other-content-top", column: 4, border: "", style: { "margin-bottom": "10px" } }, { default: e(() => [t(s, { label: "项目" }, { default: e(() => [i(r(n(Se)(o.detailInfo.project)), 1)]), _: 1 }), t(s, { label: "收货单位" }, { default: e(() => [i(r(o.detailInfo.receiptUnit), 1)]), _: 1 }), t(s, { label: "收货人" }, { default: e(() => [i(r(o.detailInfo.receiptName), 1)]), _: 1 }), t(s, { label: "联系电话" }, { default: e(() => [i(r(o.detailInfo.receiptPhone), 1)]), _: 1 }), t(s, { label: "物流单位" }, { default: e(() => {
      var a;
      return [i(r((a = o.detailInfo.supplier) == null ? void 0 : a.name), 1)];
    }), _: 1 }), t(s, { label: "车牌/船牌号" }, { default: e(() => [i(r(o.detailInfo.licensePlate), 1)]), _: 1 }), t(s, { label: "司机电话" }, { default: e(() => [i(r(o.detailInfo.driverPhone), 1)]), _: 1 }), t(s, { label: "发运日期" }, { default: e(() => [i(r(n(Ue)(o.detailInfo.actualTime)), 1)]), _: 1 }), t(s, { label: "车次/船次" }, { default: e(() => [i(r(o.detailInfo.serialNumber), 1)]), _: 1 }), t(s, { label: "装车人" }, { default: e(() => [i(r(o.detailInfo.userNames), 1)]), _: 1 }), t(s, { label: "过磅人" }, { default: e(() => [i(r(o.detailInfo.actualUserName), 1)]), _: 1 }), t(s, { label: "审核人" }, { default: e(() => [i(r(o.detailInfo.auditUserName), 1)]), _: 1 })]), _: 1 })), [[N, w.value]]), h((u(), d(le, { data: j.value || [], "show-summary": "", "summary-method": te, "max-height": n(Q), "empty-text": "暂无数据", style: { width: "100%" } }, { default: e(() => [t(c, { label: "序号", type: "index", align: "center", width: "60" }), t(c, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体" }), t(c, { "show-overflow-tooltip": true, prop: "productType", align: "center", label: "产品类型", width: "90" }, { default: e((a) => {
      var E;
      return [f.projectType === n(H).BRIDGE.V ? (u(), d(z, { key: 0, type: (E = n(P).V[a.row.productType]) == null ? void 0 : E.T, effect: "plain", style: { "margin-right": "5px" } }, { default: e(() => [i(r(n(P).VL[a.row.productType]), 1)]), _: 2 }, 1032, ["type"])) : (u(true), x(D, { key: 1 }, M(n(Be).ENUM, (m) => (u(), x(D, { key: m }, [a.row.productType & m.V ? (u(), d(z, { key: 0, type: m == null ? void 0 : m.T, effect: "plain", style: { "margin-right": "5px" } }, { default: e(() => [i(r(m.L), 1)]), _: 2 }, 1032, ["type"])) : k("", true)], 64))), 128))];
    }), _: 1 }), t(c, { "show-overflow-tooltip": true, prop: "name", label: "名称/类型" }, { default: e((a) => [a.row.warehouseType === 1 ? (u(), d(ae, { key: 0, name: "回厂返修", color: "#e64242", offset: 30 })) : k("", true), i(" " + r(a.row.name), 1)]), _: 1 }), t(c, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号" }), t(c, { "show-overflow-tooltip": true, prop: "specification", label: "规格" }), t(c, { "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", align: "center" }, { default: e((a) => [i(r(n(je)(a.row.length, n(Ce).MES_ARTIFACT_L__MM)), 1)]), _: 1 }), t(c, { "show-overflow-tooltip": true, align: "center", prop: "measureUnit", label: "计量单位" }), t(c, { "show-overflow-tooltip": true, align: "center", prop: "shipQuantity", label: "数量" }), t(c, { "show-overflow-tooltip": true, align: "center", prop: "accountingUnit", label: "核算单位" }), t(c, { "show-overflow-tooltip": true, align: "center", prop: "mete", label: "核算量" }), t(c, { "show-overflow-tooltip": true, prop: "packSerialNumber", label: "包单号", align: "center" }, { default: e((a) => [i(r(a.row.packSerialNumber || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[N, w.value]]), h((u(), d(O, { class: "other-content-bottom", column: 1, border: "", style: { "margin-top": "10px" } }, { default: e(() => {
      var a;
      return [(a = o.detailInfo.attachmentList) != null && a.length ? (u(), d(s, { key: 0, label: "装车图片" }, { default: e(() => [A("div", Fe, [(u(true), x(D, null, M(o.detailInfo.attachmentList, (E) => (u(), d(oe, { "preview-src-list": o.detailInfo.attachmentList.map((m) => m.imageUrl), "initial-index": 1, key: E.id, src: E.imageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })) : k("", true), t(s, { label: "备注" }, { default: e(() => [A("span", null, r(o.detailInfo.remark || "-"), 1)]), _: 1 })];
    }), _: 1 })), [[N, w.value]]), t(se, { title: "选择取消发运方式", modelValue: g.value, "onUpdate:modelValue": l[2] || (l[2] = (a) => g.value = a), "close-on-click-modal": false, "show-close": false, width: "700px" }, { titleRight: e(() => [t(L, { type: "primary", size: "default", loading: y.submitLoading, onClick: Y }, { default: e(() => l[6] || (l[6] = [i(" 确认 ")])), _: 1, __: [6] }, 8, ["loading"]), t(L, { size: "default", onClick: l[0] || (l[0] = fe((a) => g.value = false, ["stop"])) }, { default: e(() => l[7] || (l[7] = [i("关闭")])), _: 1, __: [7] })]), default: e(() => [t(re, { ref_key: "formRef", ref: U, model: v.value, rules: J, size: "default", "label-width": "90px" }, { default: e(() => [t(ne, { label: "选择类型", prop: "cargoListReceiptTypeEnum" }, { default: e(() => [t(ie, { class: "filter-item", modelValue: v.value.cargoListReceiptTypeEnum, "onUpdate:modelValue": l[1] || (l[1] = (a) => v.value.cargoListReceiptTypeEnum = a), options: n(_).ENUM, type: "enum", size: "default" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue"]), t(n(ze), { modelValue: R.value, "onUpdate:modelValue": l[3] || (l[3] = (a) => R.value = a), detailInfo: o.detailInfo, cargoListReceiptTypeEnum: n(_).NO_RESERVED_LOADING.V, onSuccess: ee, projectType: f.projectType }, null, 8, ["modelValue", "detailInfo", "cargoListReceiptTypeEnum", "projectType"])]), _: 2 }, [o.detailInfo.status === n(De).SHIPMENT.V && o.detailInfo.deliveryStatus !== n(ke).RETURN.V ? { name: "titleRight", fn: e(() => [h((u(), d(L, { size: "mini", type: "danger", onClick: X }, { default: e(() => l[5] || (l[5] = [i(" 取消发运 ")])), _: 1, __: [5] })), [[F, n(B).del]])]), key: "0" } : void 0]), 1032, ["modelValue", "before-close"]);
  };
} }, Qe = Le(Me, [["__scopeId", "data-v-5e1934df"]]);
export {
  Qe as default
};
