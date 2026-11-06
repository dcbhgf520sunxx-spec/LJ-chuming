import { ref as c } from "vue";
import { resolveComponent as j } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as B } from "vue";
import { createVNode as l } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as t } from "vue";
import { unref as v } from "vue";
import { createTextVNode as i } from "vue";
import { createBlock as N } from "vue";
import { createCommentVNode as A } from "vue";
import { withDirectives as q } from "vue";
import { toDisplayString as n } from "vue";
import { ElFormItem as z } from "element-plus";
import { ElRadio as U } from "element-plus";
import { ElRadioGroup as F } from "element-plus";
import { ElButton as M } from "element-plus";
import { ElForm as G } from "element-plus";
import { ElCard as H } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { l as Y, _ as J, bY as S, q as K } from "../../../../../../shared/runtime.js";
function Q(u) {
  return Y({ module: "mes", url: "craft/painting-craft/uniform-list", method: "get", params: u });
}
const W = { class: "header-form" }, X = { style: { display: "flex" } }, Z = { __name: "index", props: { projectData: { type: Object, default: () => {
} } }, emits: ["close"], setup(u, { emit: y }) {
  const E = y, w = u, m = c({ paintingTypeEnum: S.PRIMER.V, boolALLmonomer: false, monomerId: void 0 }), x = c(false), V = c([]), I = { paintingTypeEnum: [{ required: true, message: "请选择油漆类型", trigger: "change" }], monomerId: [{ required: true, message: "请选择单体", trigger: "change" }] };
  async function L() {
    var o;
    const p = { projectId: (o = w.projectData) == null ? void 0 : o.projectId, paintingTypeEnum: m.value.paintingTypeEnum, monomerId: m.value.monomerId };
    try {
      const s = await Q(p);
      console.log(s, "dsadasdsa");
    } catch (s) {
      console.log(s);
    }
  }
  L();
  function f() {
    E("close");
  }
  return (p, o) => {
    const s = j("common-radio-button"), d = z, b = U, C = F, g = M, T = G, D = H, r = O, R = j("common-table"), h = P;
    return _(), B("div", null, [l(D, null, { default: a(() => [l(T, { ref: "formRef", model: m.value, rules: I, size: "small", "label-width": "140px" }, { default: a(() => [t("div", W, [t("div", X, [l(d, { label: "请选择油漆类型：", prop: "paintingTypeEnum" }, { default: a(() => [l(s, { modelValue: m.value.paintingTypeEnum, "onUpdate:modelValue": o[0] || (o[0] = (e) => m.value.paintingTypeEnum = e), options: v(S).ENUM, size: "small", type: "enum", class: "filter-item", onChange: p.handleTypeChange }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 }), l(d, { label: "", prop: "boolALLmonomer", style: { "margin-left": "-110px" } }, { default: a(() => [l(C, { modelValue: m.value.boolALLmonomer, "onUpdate:modelValue": o[1] || (o[1] = (e) => m.value.boolALLmonomer = e), size: "small", class: "filter-item" }, { default: a(() => [o[5] || (o[5] = i(" `")), l(b, { value: false }, { default: a(() => o[3] || (o[3] = [i("全部单体")])), _: 1, __: [3] }), o[6] || (o[6] = i(" `")), l(b, { value: true }, { default: a(() => o[4] || (o[4] = [i("仅限单体")])), _: 1, __: [4] })]), _: 1, __: [5, 6] }, 8, ["modelValue"])]), _: 1 }), m.value.boolALLmonomer ? (_(), N(d, { key: 0, label: "", prop: "monomerId", style: { "margin-left": "-110px" } }, { default: a(() => {
      var e;
      return [l(v(K), { ref: "monomerRef", modelValue: m.value.monomerId, "onUpdate:modelValue": o[2] || (o[2] = (k) => m.value.monomerId = k), clearable: "", "project-id": (e = u.projectData) == null ? void 0 : e.projectId, class: "filter-item", placeholder: "可选择单体", default: false }, null, 8, ["modelValue", "project-id"])];
    }), _: 1 })) : A("", true)]), t("div", null, [l(g, { onClick: f }, { default: a(() => o[7] || (o[7] = [i("关闭")])), _: 1, __: [7] }), l(g, { type: "success", onClick: f }, { default: a(() => o[8] || (o[8] = [i("保存")])), _: 1, __: [8] })])])]), _: 1 }, 8, ["model"])]), _: 1 }), q((_(), N(R, { ref: "tableRef", data: V.value, "empty-text": "暂无数据", "max-height": p.maxHeight, style: { width: "100%" } }, { default: a(() => [l(r, { prop: "projectSerialNumber", label: "主次构件", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "类型", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "构件数量（件）", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "构件重量（吨）", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "涂装面积", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "漆膜厚度（um）", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "品牌", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "油漆类型", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "损耗系数", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "单位", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 }), l(r, { prop: "projectSerialNumber", label: "油漆使用量", align: "center" }, { default: a((e) => [t("span", null, n(e.row.projectSerialNumber), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[h, x.value]])]);
  };
} }, ae = J(Z, [["__scopeId", "data-v-95aa5244"]]);
export {
  ae as default
};
