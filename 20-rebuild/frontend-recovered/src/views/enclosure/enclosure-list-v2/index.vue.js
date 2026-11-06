import { ref as s } from "vue";
import { onMounted as M } from "vue";
import { provide as x } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as t } from "vue";
import { withDirectives as Q } from "vue";
import { unref as a } from "vue";
import { createBlock as W } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as R } from "vue";
import { toDisplayString as f } from "vue";
import { createCommentVNode as z } from "vue";
import { ElMessageBox as G } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElSwitch as Y } from "element-plus";
import { vLoading as j } from "element-plus";
import { _ as J, x as K, m6 as Z, m7 as D, o as ee, m8 as c, G as te, P as oe, m9 as h, ma as ne, mb as ae } from "../../../shared/runtime.js";
import le from "./module/header.vue.js";
import ie from "./module/form.vue.js";
import se from "./module/detail.vue.js";
import "./components/ExcelUploadBtn.vue.js";
import "../../../modules/artifact-tree-bcd3b733.js";
import "../../../modules/index-8356a01a.js";
const re = { class: "app-container" }, ce = { key: 0, class: "status-mark" }, me = { __name: "index", setup(ue) {
  const _ = s([]), k = s(), m = s(), v = s(false), u = s({}), { crud: l, CRUD: P } = K({ title: "围护清单", crudApi: { ...Z }, queryOnPresenterCreated: false, permission: D, requiredQuery: ["monomerId", "areaId"], props: { selectList: [] } }, k), { maxHeight: A } = ee({ paginate: true }), N = s(true);
  function U(o, i) {
    l.props.selectList = o;
  }
  function T(o) {
    l.props.selectList = o;
  }
  async function I(o, i) {
    try {
      const e = i === 1 ? "启用" : "暂停";
      await G.confirm("确定" + e + "?", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ne(o.id, { boolStatusEnum: !!i }), l.notify(`“${o.name}”已【${e}】`, P.NOTIFICATION_TYPE.SUCCESS), l.toQuery();
    } catch (e) {
      console.log("修改围护状态", e), o.boolStatusEnum = o.boolStatusEnum === c.PROCESS.V ? c.PAUSE.V : c.PROCESS.V;
    }
  }
  async function B() {
    try {
      const { content: o } = await ae();
      _.value = o || [];
    } catch (o) {
      console.log(o);
    }
  }
  function L(o) {
    const { quantity: i, producedQuantity: e } = o;
    o.notProduced = Number(i) - Number(e), u.value = o, l.toDetail();
  }
  M(() => {
    B();
  });
  function O() {
    u.value = null;
  }
  return x("technicalTypeStatus", N), x("enclosureDictList", _), (o, i) => {
    var g, w, b, y, E, S;
    const e = X, q = Y, F = C("common-button"), $ = C("common-table"), H = j;
    return p(), V("div", re, [t(le, { ref_key: "headerRef", ref: m }, null, 512), Q((p(), W($, { data: a(l).data, "empty-text": a(l).query.monomerId ? a(l).emptyText : "请先选择单体", "max-height": a(A), showEmptySymbol: false, onSelect: U, onSelectAll: T }, { default: r(() => [t(e, { align: "center", type: "selection", width: "60" }), t(e, { align: "center", label: "序号", type: "index", width: "60" }), t(e, { align: "left", label: "类型", "min-width": "120", prop: "dictionaryName" }), t(e, { align: "left", label: "名称", "min-width": "120", prop: "name" }), t(e, { align: "left", label: "编号", "min-width": "120", prop: "serialNumber" }), t(e, { align: "left", label: "规格", "min-width": "120", prop: "plate", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "展开宽度", "min-width": "100", prop: "unfoldedWidth" }), t(e, { align: "left", label: "有效宽度", "min-width": "100", prop: "width", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "厚度（mm）", "min-width": "120", prop: "thickness", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "单长（mm）", "min-width": "120", prop: "length", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "数量", "min-width": "70", prop: "quantity" }), t(e, { align: "left", label: "核算量（米）", "min-width": "120", prop: "accountingVolume", "show-overflow-tooltip": "" }), t(e, { align: "left", label: "总面积（m²）", "min-width": "100", prop: "totalArea" }, { default: r(({ row: n }) => [R("span", null, f(n.totalArea.toFixed(4)), 1)]), _: 1 }), t(e, { align: "left", label: "总重量（kg）", "min-width": "100", prop: "totalWeight" }, { default: r(({ row: n }) => [R("span", null, f(n.totalWeight.toFixed(3)), 1)]), _: 1 }), t(e, { align: "left", label: "备注", "min-width": "140", prop: "remark" }), t(e, { align: "left", fixed: "right", label: "状态", "min-width": "70", prop: "boolStatusEnum" }, { default: r(({ row: n }) => [t(q, { modelValue: n.boolStatusEnum, "onUpdate:modelValue": (d) => n.boolStatusEnum = d, "active-value": a(c).PROCESS.V, disabled: !a(te)(a(D).edit), "inactive-value": a(c).PAUSE.V, "active-color": "#13ce66", onChange: (d) => I(n, n.boolStatusEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 }), t(e, { align: "center", fixed: "right", label: "操作", width: "80" }, { default: r(({ row: n }) => [t(F, { icon: "el-icon-view", size: "default", type: "primary", onClick: (d) => L(n) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[H, a(l).loading]]), t(oe), ((w = (g = m.value) == null ? void 0 : g.inventoryReviewedData) == null ? void 0 : w.inventoryReviewedEnum) === a(h).FIXUP_RECORD.V || ((y = (b = m.value) == null ? void 0 : b.inventoryReviewedData) == null ? void 0 : y.inventoryReviewedEnum) === a(h).UNAUDITED.V ? (p(), V("div", ce, f(a(h).VL[(S = (E = m.value) == null ? void 0 : E.inventoryReviewedData) == null ? void 0 : S.inventoryReviewedEnum]), 1)) : z("", true), t(se, { modelValue: v.value, "onUpdate:modelValue": i[0] || (i[0] = (n) => v.value = n), "current-row": u.value, onClose: O }, null, 8, ["modelValue", "current-row"]), t(ie)]);
  };
} }, be = J(me, [["__scopeId", "data-v-c44e1127"]]);
export {
  be as default
};
