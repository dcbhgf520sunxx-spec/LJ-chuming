import { ref as c } from "vue";
import { computed as j } from "vue";
import { ElMessage as Q } from "element-plus";
import { resolveComponent as y } from "vue";
import { openBlock as b } from "vue";
import { createBlock as C } from "vue";
import { withCtx as t } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as m } from "vue";
import { toDisplayString as u } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as v } from "vue";
import { createElementBlock as H } from "vue";
import { Fragment as K } from "vue";
import { createElementVNode as $ } from "vue";
import { ElTag as G } from "element-plus";
import { ElDescriptionsItem as J } from "element-plus";
import { ElDescriptions as W } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { e as ee } from "../../../../../../modules/coating-list-667107a8.js";
import { ef as V, ao as te, aw as ae } from "../../../../../../shared/runtime.js";
import le from "../editList/index.vue.js";
import "../editList/module/detail.vue.js";
import "../editList/module/header.vue.js";
const ce = { __name: "from", setup(oe) {
  const R = { detailList: [{ paintType: V.PRIMER.V }, { paintType: V.INTERMEDIATE_PAINT.V }, { paintType: V.TOPCOAT.V }] }, x = c(), U = c(), s = c(1), T = c(null), { CRUD: w, crud: d, form: o } = te(R, x), E = c([]), L = { thickness: [{ required: true, message: "请输入干膜厚度", trigger: "blur" }], paintBrand: [{ required: true, message: "请输入油漆品牌", trigger: "blur" }] };
  function z(r) {
    E.value = r;
  }
  const B = j(() => E.value.reduce((r, n) => r + n.quantity, 0)), { tableValidate: N, wrongCellMask: M } = ae({ rules: L }), D = c([{ L: "修改油漆类型", V: 1 }, { L: "修改清单", V: 2 }]);
  w.HOOK.beforeValidateCU = () => {
    const r = o.detailList[0], { validResult: n, dealList: h } = N([r]);
    if (!n) return n;
    let p = false;
    if (o.detailList.map((_) => {
      _.paintBrand && !_.thickness && (p = true);
    }), p) return Q.error("录入油漆品牌，干膜厚度为必填"), !p;
  };
  function I() {
    s.value = 1;
  }
  async function A() {
    const r = { artifactList: T.value.dataList, id: o.id };
    try {
      await ee(r), d.cancelCU(), d.refresh();
    } catch (n) {
      console.log(n);
    }
  }
  function F() {
    s.value === 1 ? d.submitCU() : A();
  }
  return (r, n) => {
    const h = G, p = y("common-button"), _ = y("component-radio-button"), k = J, O = W, f = X, g = Y, S = y("common-table"), q = Z, P = y("common-drawer");
    return b(), C(P, { ref_key: "drawerRef", ref: U, "append-to-body": "", "close-on-click-modal": false, "before-close": l(d).cancelCU, visible: l(d).status.cu > 0, title: "涂装工艺修改", "wrapper-closable": false, "custom-class": "detail", onOpen: I, size: "70%" }, { titleAfter: t(() => [e(h, { effect: "plain", size: "large", style: { "margin-right": "10px" } }, { default: t(() => [m("工艺编号：" + u(l(o).serialNumber), 1)]), _: 1 }), s.value === 2 ? (b(), C(h, { key: 0, effect: "plain", size: "large" }, { default: t(() => [m("总件数：" + u(B.value), 1)]), _: 1 })) : v("", true)]), titleRight: t(() => [e(p, { loading: l(d).status.cu === 2, type: "success", size: "default", onClick: F }, { default: t(() => n[1] || (n[1] = [m("保存")])), _: 1, __: [1] }, 8, ["loading"])]), content: t(() => [e(_, { modelValue: s.value, "onUpdate:modelValue": n[0] || (n[0] = (a) => s.value = a), options: D.value, type: "enum", size: "default", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["modelValue", "options"]), s.value === 1 ? (b(), H(K, { key: 0 }, [e(O, { column: 2, border: "" }, { default: t(() => [e(k, { label: "项目", align: "center", span: 2 }, { default: t(() => [m(u(l(o).contractProjectSerialNumber) + " " + u(l(o).contractProjectShortName), 1)]), _: 1 }), e(k, { label: "构件数量", align: "center", span: 1 }, { default: t(() => [m(u(l(o).artifactQuantity) + " 件", 1)]), _: 1 }), e(k, { label: "总面积", align: "center", span: 1 }, { default: t(() => [m(u(l(o).totalArea) + " ㎡", 1)]), _: 1 })]), _: 1 }), e(q, { ref_key: "formRef", ref: x, model: l(o), size: "default", "label-width": "80px" }, { default: t(() => [e(S, { ref: "tableRef", data: l(o).detailList, "show-empty-symbol": false, "return-source-data": "", "cell-class-name": l(M), style: { "margin-top": "10px" }, showEmptySymbol: false }, { default: t(() => [e(f, { prop: "paintType", label: "油漆类型", align: "center" }, { default: t(({ row: a }) => [$("span", null, u(l(V).VL[a.paintType]), 1)]), _: 1 }), e(f, { prop: "paintBrand", label: "油漆品牌", align: "center" }, { default: t(({ row: a }) => [e(g, { modelValue: a.paintBrand, "onUpdate:modelValue": (i) => a.paintBrand = i, modelModifiers: { trim: true }, type: "text", placeholder: "油漆品牌", size: "default", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(f, { prop: "paintCategory", label: "油漆种类", align: "center" }, { default: t(({ row: a }) => [e(g, { modelValue: a.paintCategory, "onUpdate:modelValue": (i) => a.paintCategory = i, modelModifiers: { trim: true }, type: "text", placeholder: "油漆种类", size: "default", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(f, { prop: "thickness", label: "干膜厚度", align: "center" }, { default: t(({ row: a }) => [e(g, { modelValue: a.thickness, "onUpdate:modelValue": (i) => a.thickness = i, modelModifiers: { trim: true }, oninput: "value=value.replace(/[^\\d.]/g, '')", type: "text", placeholder: "干膜厚度", size: "default", maxlength: "20", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(f, { prop: "remark", label: "备注", align: "center" }, { default: t(({ row: a }) => [e(g, { modelValue: a.remark, "onUpdate:modelValue": (i) => a.remark = i, modelModifiers: { trim: true }, rows: 2, type: "textarea", size: "default", maxlength: "100", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["model"])], 64)) : v("", true), s.value === 2 ? (b(), C(l(le), { key: 1, ref_key: "editListRef", ref: T, id: l(o).id, onChecklist: z }, null, 8, ["id"])) : v("", true)]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  ce as default
};
