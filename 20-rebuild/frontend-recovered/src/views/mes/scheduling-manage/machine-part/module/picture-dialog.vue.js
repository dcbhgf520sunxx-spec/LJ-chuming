import { ref as b } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as c } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { unref as n } from "vue";
import { createTextVNode as p } from "vue";
import { createElementVNode as q } from "vue";
import { withDirectives as F } from "vue";
import { isRef as H } from "vue";
import { ElButton as L } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { ElTag as E } from "element-plus";
import { vLoading as A } from "element-plus";
import { u as P, o as U, q as M, r0 as O, r1 as $, ba as G } from "../../../../../shared/runtime.js";
import J from "../../../../plan/technical-data-manage/technical-achievement/components/drawing-upload-btn.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const K = { style: { display: "flex", "margin-bottom": "10px" } }, ee = { __name: "picture-dialog", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => ({}) }, rePictureList: { type: Array, default: () => [] }, projectId: { type: [Number, String] } }, emits: ["update:visible", "close", "success", "handleDel", "pictureState", "handleBatchDel"], setup(s, { emit: x }) {
  const d = x, g = s, { visible: u, handleClose: h } = P({ emit: d, props: g, field: "visible", showHook: C, closeHook: () => {
    d("close");
  } }), { maxHeight: k } = U({ wrapperBox: [".el-dialog__body"], minHeight: 300, navbar: false, paginate: true }, u), w = b(false), r = b(), f = b([]);
  function j(o) {
    f.value = o;
  }
  function C() {
  }
  function I(o, e) {
    d("handleDel", { row: o, id: e, type: 3 });
  }
  const V = () => {
    d("handleBatchDel", { list: f.value, type: 3 });
  }, S = (o) => {
    d("pictureState", { projectId: g.projectId, monomerId: r.value, type: o });
  }, B = (o) => G(o, { props: ["quantity"] });
  return (o, e) => {
    const D = L, _ = y("common-button"), i = R, v = E, z = y("common-table"), N = y("common-drawer"), T = A;
    return c(), m(N, { title: "批量覆盖", modelValue: n(u), "onUpdate:modelValue": e[1] || (e[1] = (l) => H(u) ? u.value = l : null), "show-close": false, "before-close": n(h), size: "50%" }, { titleAfter: a(() => e[2] || (e[2] = [])), titleRight: a(() => [t(D, { size: "default", onClick: n(h) }, { default: a(() => e[3] || (e[3] = [p("关闭")])), _: 1, __: [3] }, 8, ["onClick"])]), content: a(() => [q("div", K, [t(n(M), { ref: "monomerRef", modelValue: r.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => r.value = l), "project-id": s.projectId, placeholder: "可选择单体", clearable: "", default: false, class: "filter-item", style: { width: "200px", "margin-left": "10px" } }, null, 8, ["modelValue", "project-id"])]), t(J, { dataType: 2, accept: ".zip,.dxf", data: { monomerId: r.value, projectId: s.projectId, productType: 1, dataType: 2 }, "upload-fun": n(O), uploadFunFile: n($), "btn-name": "覆盖导入", disabled: !s.projectId || !r.value, size: "default", type: "primary", tip: ".dxf", onSuccess: S }, null, 8, ["data", "upload-fun", "uploadFunFile", "disabled"]), t(_, { type: "danger", icon: "el-icon-delete", size: "default", disabled: !f.value.length, style: { float: "right" }, onClick: V }, { default: a(() => e[4] || (e[4] = [p(" 批量删除 ")])), _: 1, __: [4] }, 8, ["disabled"]), F((c(), m(z, { "return-source-data": "", data: s.rePictureList, "show-summary": "", "summary-method": B, "max-height": n(k), style: { width: "100%", "margin-top": "10px" }, onSelectionChange: j }, { default: a(() => [t(i, { type: "selection", width: "55" }), t(i, { label: "序号", type: "index", align: "center", width: "60" }), t(i, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120", align: "center" }), t(i, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), t(i, { key: "state", prop: "state", label: "覆盖状态", align: "center" }, { default: a(({ row: l }) => [l != null && l.state ? (c(), m(v, { key: 0, type: "success" }, { default: a(() => e[5] || (e[5] = [p("成功")])), _: 1, __: [5] })) : (c(), m(v, { key: 1, type: "primary" }, { default: a(() => e[6] || (e[6] = [p("未覆盖")])), _: 1, __: [6] }))]), _: 1 }), t(i, { label: "操作", width: "80", align: "center" }, { default: a(({ row: l }) => [t(_, { type: "danger", icon: "el-icon-delete", size: "default", onClick: (Q) => I(l, l.id) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[T, w.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ee as default
};
