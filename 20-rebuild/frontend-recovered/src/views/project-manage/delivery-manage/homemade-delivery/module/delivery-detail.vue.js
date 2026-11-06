import { watch as q } from "vue";
import { ref as k } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as $ } from "vue";
import { openBlock as m } from "vue";
import { createBlock as V } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as c } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as d } from "vue";
import { withDirectives as E } from "vue";
import { createElementBlock as p } from "vue";
import { Fragment as A } from "vue";
import { createCommentVNode as C } from "vue";
import { isRef as F } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElNotification as G } from "element-plus";
import { ElTag as J } from "element-plus";
import { ElPopconfirm as Q } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { l as h, u as Y, o as Z, i as L, kM as T, K as ee, F as te, ba as oe } from "../../../../../shared/runtime.js";
function ae(e) {
  return h({ module: "project", url: "receiving/listReceiving", method: "get", params: e });
}
function ne(e) {
  return h({ module: "project", url: "receiving/confirmReceiving", method: "post", data: e });
}
function re(e, w) {
  return h({ module: "project", url: `receiving/listProduct/${e}`, method: "get", params: w });
}
const ie = { edit: ne, get: ae }, le = { key: 0, style: { color: "red", "font-size": "13px", "margin-bottom": "10px" } }, ce = { key: 0 }, se = { key: 1 }, me = { key: 0 }, ue = { key: 1 }, de = { __name: "delivery-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: "detail" } }, emits: ["update:modelValue", "success"], setup(e, { emit: w }) {
  const x = w, u = e, { visible: g, handleClose: j } = Y({ emit: x, props: u });
  q(g, (n) => {
    n && D();
  });
  const N = k([]), I = k(), v = k(false), { maxHeight: B } = Z({ mainBox: ".delivery-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, I);
  function S(n) {
    return oe(n, { props: ["accountingMete"] });
  }
  async function D() {
    var o;
    let n = [];
    v.value = true;
    try {
      const { content: i = [] } = await re((o = u.detailInfo) == null ? void 0 : o.id, { projectId: u.globalProject.id });
      i.map((s) => {
        var f, b;
        s.monomerName = (f = s.monomer) == null ? void 0 : f.name, s.areaName = (b = s.area) == null ? void 0 : b.name;
      }), n = i;
    } catch (i) {
      console.log("收货明细", i);
    } finally {
      N.value = n, v.value = false;
    }
  }
  const z = (n) => (!n || !n.trim()) && n !== 0 ? "必填" : n.length > 200 ? "长度在 1 到 200 个字符" : true;
  async function R(n) {
    var o;
    try {
      const i = n === 1 ? await K.prompt("请输入问题描述", "", { confirmButtonText: "确定", cancelButtonText: "取消", inputType: "textarea", inputValidator: z, type: "warning" }) : void 0, s = { boolProblemReceiving: n, cargoListId: (o = u.detailInfo) == null ? void 0 : o.id, projectId: u.globalProject.id, problemDesc: n === 1 ? i.value : void 0 };
      await ie.edit(s), G({ title: "提交成功", type: "success" }), x("success"), j();
    } catch (i) {
      console.log("审核", i);
    }
  }
  return (n, o) => {
    const i = J, s = _("print-table"), f = _("common-button"), b = Q, l = W, M = _("common-table"), O = _("common-drawer"), H = $("permission"), U = X;
    return m(), V(O, { ref_key: "drawerRef", ref: I, title: "详情", "close-on-click-modal": false, modelValue: c(g), "onUpdate:modelValue": o[2] || (o[2] = (a) => F(g) ? g.value = a : null), direction: "rtl", "before-close": c(j), "custom-class": "delivery-detail", size: "80%" }, { titleAfter: r(() => {
      var a;
      return [t(i, { type: c(L)(e.detailInfo.boolProblemReceiving) ? e.detailInfo.boolProblemReceiving ? "warning" : "success" : "primary", size: "large" }, { default: r(() => [y(d(c(L)(e.detailInfo.boolProblemReceiving) ? e.detailInfo.boolProblemReceiving ? "问题收货" : "正常收货" : "未收货"), 1)]), _: 1 }, 8, ["type"]), t(i, { size: "large" }, { default: r(() => [y(d(`车牌/船牌号：${e.detailInfo.licensePlate}`), 1)]), _: 1 }), E(t(s, { "api-key": "deliveryCargoList", params: { cargoListId: (a = u.detailInfo) == null ? void 0 : a.id, projectId: e.globalProject.id }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[H, e.permission.print]])];
    }), titleRight: r(() => [e.showType === "edit" ? (m(), p(A, { key: 0 }, [t(f, { type: "danger", size: "default", onClick: o[0] || (o[0] = (a) => R(1)) }, { default: r(() => o[3] || (o[3] = [y("问题收货")])), _: 1, __: [3] }), t(b, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "#626AEF", title: "确定收货吗?", onConfirm: o[1] || (o[1] = (a) => R(0)) }, { reference: r(() => [t(f, { type: "success", size: "default" }, { default: r(() => o[4] || (o[4] = [y("确定收货")])), _: 1, __: [4] })]), _: 1 })], 64)) : C("", true)]), content: r(() => [e.detailInfo.boolProblemReceiving && e.detailInfo.problemDesc ? (m(), p("div", le, "*" + d(e.detailInfo.problemDesc), 1)) : C("", true), E((m(), V(M, { data: N.value, "show-summary": "", "summary-method": S, "max-height": c(B) }, { default: r(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { key: "monomerName", prop: "monomerName", label: "单体", align: "center" }), t(l, { key: "areaName", prop: "areaName", label: "区域", align: "center" }, { default: r((a) => [a.row.sourceRow.productType !== c(T).ENCLOSURE.V ? (m(), p("span", ce, d(a.row.areaName), 1)) : (m(), p("span", se, "-"))]), _: 1 }), t(l, { key: "areaName1", prop: "areaName", label: "批次", align: "center" }, { default: r((a) => [a.row.sourceRow.productType === c(T).ENCLOSURE.V ? (m(), p("span", me, d(a.row.areaName), 1)) : (m(), p("span", ue, "-"))]), _: 1 }), t(l, { key: "productType", prop: "productType", label: "类型", align: "center" }, { default: r((a) => [t(i, null, { default: r(() => {
      var P;
      return [y(d(e.globalProject.projectType === c(ee).STEEL.V ? (P = c(T).V[a.row.productType === 1 || a.row.productType === 16 ? 17 : a.row.productType]) == null ? void 0 : P.SL : c(te).VL[a.row.productType]), 1)];
    }), _: 2 }, 1024)]), _: 1 }), t(l, { key: "name", prop: "name", label: "名称", align: "center" }), t(l, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), t(l, { key: "specification", prop: "specification", label: "规格", align: "center" }), t(l, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), t(l, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), t(l, { key: "accountingMete", prop: "accountingMete", label: "核算量", align: "center" })]), _: 1 }, 8, ["data", "max-height"])), [[U, v.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ye = Object.freeze(Object.defineProperty({ __proto__: null, default: de }, Symbol.toStringTag, { value: "Module" }));
export {
  de as _,
  ie as c,
  ye as d
};
