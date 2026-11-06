import { ref as g } from "vue";
import { inject as u } from "vue";
import { resolveComponent as $ } from "vue";
import { openBlock as m } from "vue";
import { createBlock as x } from "vue";
import { withCtx as s } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as N } from "vue";
import { createElementBlock as U } from "vue";
import { Fragment as V } from "vue";
import { renderList as F } from "vue";
import { ElInput as w } from "element-plus";
import { ElFormItem as I } from "element-plus";
import { ElInputNumber as R } from "element-plus";
import { ElForm as T } from "element-plus";
import { _ as A, ao as B } from "../../../../../../shared/runtime.js";
const z = { __name: "form", setup(O) {
  const p = { specification: "" }, S = g({ specification: [{ required: true, message: "请填写规格", trigger: "blur" }, { max: 50, message: "不能超过50个字符", trigger: "blur" }] }), l = u("prefix"), c = u("standard"), h = u("sectionSteel");
  c.value.forEach((t) => {
    p[`${l}${t.id}`] = void 0;
  });
  const _ = g(), { CRUD: d, crud: n, form: i } = B(p, _);
  return n.submitFormFormat = (t) => (t.sectionSteelId = h.value.id, t.standard = [], c.value.forEach((o) => {
    t[`${l}${o.id}`] && t.standard.push({ id: o.id, unitNet: t[`${l}${o.id}`] }), delete t[`${l}${o.id}`];
  }), t), (t, o) => {
    const f = $("common-button"), y = w, b = I, k = R, v = T, C = $("common-dialog");
    return m(), x(C, { "append-to-body": "", "close-on-click-modal": false, visible: e(n).status.cu > e(d).STATUS.NORMAL, "before-close": e(n).cancelCU, title: e(n).status.title, "show-close": true, "custom-class": "section-steel-detail-form", width: "400px" }, { titleRight: s(() => [r(f, { loading: e(n).status.cu === e(d).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(n).submitCU }, { default: s(() => o[1] || (o[1] = [N(" 确认 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), default: s(() => [r(v, { ref_key: "formRef", ref: _, model: e(i), rules: S.value, disabled: e(n).status.cu === e(d).STATUS.PROCESSING, "label-position": "top", size: "default", "label-width": "55px" }, { default: s(() => [r(b, { label: "规格", prop: "specification" }, { default: s(() => [r(y, { modelValue: e(i).specification, "onUpdate:modelValue": o[0] || (o[0] = (a) => e(i).specification = a), modelModifiers: { trim: true }, type: "text", placeholder: "规格", style: { width: "350px" } }, null, 8, ["modelValue"])]), _: 1 }), (m(true), U(V, null, F(e(c), (a) => (m(), x(b, { key: `${e(l)}${a.id}`, label: `${a.name} 理论重量(kg/m)`, prop: `${e(l)}${a.id}`, "label-width": "100px" }, { default: s(() => [r(k, { class: "align-left", modelValue: e(i)[`${e(l)}${a.id}`], "onUpdate:modelValue": (E) => e(i)[`${e(l)}${a.id}`] = E, type: "text", placeholder: `${a.name} 理论重量(kg/m)`, "controls-position": "right", style: { width: "350px" }, min: 1e-3 }, null, 8, ["modelValue", "onUpdate:modelValue", "placeholder"])]), _: 2 }, 1032, ["label", "prop"]))), 128))]), _: 1 }, 8, ["model", "rules", "disabled"])]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} }, L = A(z, [["__scopeId", "data-v-36eef023"]]);
export {
  L as default
};
