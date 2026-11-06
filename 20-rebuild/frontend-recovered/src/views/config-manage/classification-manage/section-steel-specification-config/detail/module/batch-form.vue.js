import { inject as f } from "vue";
import { ref as I } from "vue";
import { computed as D } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as b } from "vue";
import { createBlock as x } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as $ } from "vue";
import { createElementBlock as L } from "vue";
import { Fragment as j } from "vue";
import { renderList as G } from "vue";
import { withModifiers as P } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElInputNumber as J } from "element-plus";
import { ElForm as Q } from "element-plus";
import { a_ as W, o as X, b4 as Y, aw as Z } from "../../../../../../shared/runtime.js";
import { u as ee } from "../../../../../../modules/use-table-operate-4f84437f.js";
const te = { style: { float: "right" } }, ie = { __name: "batch-form", setup(ae) {
  const C = { specification: [{ required: true, max: 20, message: "不能超过50个字符", trigger: "blur" }] }, r = f("prefix"), p = f("standard"), S = f("sectionSteel"), k = { list: [] }, h = { specification: void 0 };
  p.value.forEach((o) => {
    h[`${r}${o.id}`] = void 0;
  });
  const w = I(), { CRUD: m, crud: s, form: c, ADD_FORM: B } = W(k, w), g = D(() => s.bStatus.cu > m.STATUS.NORMAL), { init: V, addRow: R, removeRow: U } = ee(h, 10), { tableValidate: v, cleanUpData: E, wrongCellMask: N } = Z({ rules: C }), { maxHeight: T } = X({ mainBox: ".section-steel-detail-batch-form", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, navbar: false }, g);
  return B.init = () => V(c.list), m.HOOK.beforeValidateBCU = () => {
    const { validResult: o, dealList: t } = v(c.list);
    if (o) c.list = t;
    else return o;
  }, s.submitBatchFormFormat = (o) => (o.sectionSteelId = S.value.id, o.list.forEach((t) => {
    t.standard = [], p.value.forEach((n) => {
      t[`${r}${n.id}`] && t.standard.push({ id: n.id, unitNet: t[`${r}${n.id}`] }), delete t[`${r}${n.id}`];
    });
  }), E(o.list), o), (o, t) => {
    const n = _("common-button"), d = q, F = K, M = J, O = _("common-table"), z = Q, A = _("common-drawer");
    return b(), x(A, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelBCU, visible: g.value, title: e(s).bStatus.title, "show-close": false, "custom-class": "section-steel-detail-batch-form", size: "85%" }, { titleRight: i(() => [y("span", te, [l(n, { size: "default", type: "success", icon: "el-icon-plus", onClick: t[0] || (t[0] = (a) => e(R)(e(c).list)) }), l(n, { loading: e(s).bStatus.cu === e(m).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(s).submitBCU }, { default: i(() => t[1] || (t[1] = [$(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), l(Y, { type: "crudBatch" }), l(n, { size: "default", onClick: e(s).cancelBCU }, { default: i(() => t[2] || (t[2] = [$("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), content: i(() => [y("div", null, [l(z, { ref_key: "formRef", ref: w, model: e(c), disabled: e(s).bStatus.cu === e(m).STATUS.PROCESSING }, { default: i(() => [l(O, { data: e(c).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": e(T) - 20, "default-expand-all": "", "cell-class-name": e(N), "row-key": "uid" }, { default: i(() => [l(d, { label: "序号", type: "index", align: "center", width: "60" }), l(d, { key: "name", prop: "specification", "show-overflow-tooltip": true, label: "规格" }, { default: i((a) => [l(F, { modelValue: a.row.specification, "onUpdate:modelValue": (u) => a.row.specification = u, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "规格", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), (b(true), L(j, null, G(e(p), (a) => (b(), x(d, { key: a.id, "show-overflow-tooltip": true, prop: `${e(r)}${a.id}`, label: `${a.name}
理论重量(kg/m)`, align: "center" }, { default: i((u) => [l(M, { class: "align-left", modelValue: u.row[`${e(r)}${a.id}`], "onUpdate:modelValue": (H) => u.row[`${e(r)}${a.id}`] = H, placeholder: `${a.name}`, type: "text", controls: false, style: { width: "100%" }, min: 1e-3 }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])]), _: 2 }, 1032, ["prop", "label"]))), 128)), l(d, { label: "操作", width: "70px", align: "center", fixed: "right" }, { default: i((a) => [l(n, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: P((u) => e(U)(e(c).list, a.$index), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  ie as default
};
