import { inject as b } from "vue";
import { computed as E } from "vue";
import { ref as C } from "vue";
import { resolveComponent as m } from "vue";
import { resolveDirective as y } from "vue";
import { openBlock as M } from "vue";
import { createBlock as S } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createTextVNode as k } from "vue";
import { withDirectives as A } from "vue";
import { createElementVNode as F } from "vue";
import { isRef as H } from "vue";
import { ElMessage as I } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { l as s, b_ as z, u as D, o as O, b as $, sE as g, au as f } from "../../../../../../shared/runtime.js";
import { _ as u } from "../../../../../../modules/index-61ce89a1.js";
function q(l) {
  return s({ module: "plan", url: "material-preparation/project-preparation", method: "get", params: l });
}
function U(l) {
  return s({ module: "plan", url: `material-preparation/project-preparation/${l}`, method: "get" });
}
function G(l) {
  return s({ module: "plan", url: "material-preparation/project-preparation", method: "put", data: l });
}
function Z() {
  return s({ module: "plan", url: "material-preparation/project-preparation/projects/range-info", method: "get" });
}
function J(l) {
  return s({ module: "plan", url: "material-preparation/project-preparation/projects/range-info", method: "put", data: l });
}
const ee = { get: q, detail: U, edit: G }, K = { __name: "preview", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] } }, emits: ["saveSuccess", "update:visible"], setup(l, { emit: x }) {
  const _ = x, w = l, v = b("crud"), j = b("sourceMap"), p = E(() => w.data.filter((i) => z(i, j))), d = C(false), { visible: c, handleClose: h } = D({ emit: _, props: w, field: "visible" }), { maxHeight: R } = O({ mainBox: ".project-preparation-range-preview-dlg", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, c);
  async function L() {
    try {
      d.value = true;
      const i = p.value.map((n) => ({ id: n.id, strucWithoutList: n.strucWithoutList, enclWithoutList: n.enclWithoutList, auxWithoutList: n.auxWithoutList, strucPreparationRangeType: n.strucPreparationRangeType, enclPreparationRangeType: n.enclPreparationRangeType, auxPreparationRangeType: n.auxPreparationRangeType }));
      await J(i), h(), v.refresh(), _("saveSuccess"), I.success("更新成功");
    } catch (i) {
      console.log("项目备料类型批量修改", i);
    } finally {
      d.value = false;
    }
  }
  return (i, n) => {
    const P = m("common-button"), r = N, T = m("common-table"), W = m("common-dialog"), B = y("parse-project"), V = y("empty-text");
    return M(), S(W, { "custom-class": "project-preparation-range-preview-dlg", title: "变更详情", "append-to-body": "", modelValue: a(c), "onUpdate:modelValue": n[0] || (n[0] = (e) => H(c) ? c.value = e : null), width: "1200px", "before-close": a(h), top: "5vh" }, { titleRight: o(() => [t(P, { loading: d.value, disabled: a($)(p.value), type: "primary", size: "default", onClick: L }, { default: o(() => n[1] || (n[1] = [k("保 存")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: o(() => [t(T, { data: p.value, "max-height": a(R), "return-source-data": "", "empty-text": "未做改动", "row-key": "id" }, { default: o(() => [t(r, { label: "序号", type: "index", align: "center", width: "60" }), t(r, { label: "项目", align: "left" }, { default: o(({ row: e }) => [A(F("span", null, null, 512), [[B, { project: e }], [V]])]), _: 1 }), t(r, { label: "结构", align: "center" }, { default: o(() => [t(r, { label: "备料范围", align: "center", width: "120" }, { default: o((e) => [t(a(u), { old: e.row.sourceStrucPreparationRangeType, new: e.row.strucPreparationRangeType, enum: a(g) }, null, 8, ["old", "new", "enum"])]), _: 1 }), t(r, { label: "无清单备料", align: "center", width: "120" }, { default: o((e) => [t(a(u), { old: e.row.sourceStrucWithoutList, new: e.row.strucWithoutList, enum: a(f) }, null, 8, ["old", "new", "enum"])]), _: 1 })]), _: 1 }), t(r, { label: "围护", align: "center" }, { default: o(() => [t(r, { label: "备料范围", align: "center", width: "120" }, { default: o((e) => [t(a(u), { old: e.row.sourceEnclPreparationRangeType, new: e.row.enclPreparationRangeType, enum: a(g) }, null, 8, ["old", "new", "enum"])]), _: 1 }), t(r, { label: "无清单备料", align: "center", width: "120" }, { default: o((e) => [t(a(u), { old: e.row.sourceEnclWithoutList, new: e.row.enclWithoutList, enum: a(f) }, null, 8, ["old", "new", "enum"])]), _: 1 })]), _: 1 }), t(r, { label: "辅材", align: "center" }, { default: o(() => [t(r, { label: "备料范围", align: "center", width: "120" }, { default: o((e) => [t(a(u), { old: e.row.sourceAuxPreparationRangeType, new: e.row.auxPreparationRangeType, enum: a(g) }, null, 8, ["old", "new", "enum"])]), _: 1 }), t(r, { label: "无清单备料", align: "center", width: "120" }, { default: o((e) => [t(a(u), { old: e.row.sourceAuxWithoutList, new: e.row.auxWithoutList, enum: a(f) }, null, 8, ["old", "new", "enum"])]), _: 1 })]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, te = Object.freeze(Object.defineProperty({ __proto__: null, default: K }, Symbol.toStringTag, { value: "Module" }));
export {
  K as _,
  ee as c,
  Z as g,
  te as p
};
