import { ref as i } from "vue";
import { nextTick as N } from "vue";
import { cloneDeep as q } from "lodash";
import { resolveComponent as a } from "vue";
import { openBlock as z } from "vue";
import { createBlock as B } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as d } from "vue";
import { toDisplayString as I } from "vue";
import { unref as f } from "vue";
import { ElMessage as D } from "element-plus";
import { ElFormItem as E } from "element-plus";
import { ElForm as F } from "element-plus";
import { u as R, dg as j } from "../../../../../shared/runtime.js";
const T = { __name: "edit-form", props: { visible: { type: Boolean, require: true }, formList: { type: Object, require: () => ({}) } }, emits: ["update:visible", "success"], setup(p, { emit: _ }) {
  const n = _, r = p, b = i(), { visible: y, handleClose: m } = R({ emit: n, props: r, field: "visible", showHook: g }), v = { classifyName: [{ required: true, message: "请填写科目名称", trigger: "blur" }], density: [{ required: true, message: "请填写密度", trigger: "blur" }] }, l = i(false), e = i({});
  function g() {
    N(() => {
      e.value = q(r.formList);
    });
  }
  async function h() {
    l.value = true;
    try {
      const c = { id: e.value.id, classifyId: e.value.classifyId, density: e.value.density };
      await j(c).then((o) => {
        o && (D.success("提交成功"), m(), n("success"));
      });
    } finally {
      l.value = false;
    }
  }
  return (c, o) => {
    const k = a("common-button"), u = E, x = a("common-input-number"), w = F, V = a("common-dialog");
    return z(), B(V, { "before-close": f(m), "close-on-click-modal": false, visible: f(y), "append-to-body": "", title: "编辑钢材密度配置", top: "5vh", width: "500px" }, { titleRight: s(() => [t(k, { loading: l.value, size: "mini", type: "primary", onClick: h }, { default: s(() => o[1] || (o[1] = [d(" 确认 ")])), _: 1, __: [1] }, 8, ["loading"])]), default: s(() => [t(w, { ref_key: "formRef", ref: b, model: e.value, rules: v, "label-width": "130px", size: "small" }, { default: s(() => [t(u, { label: "科目名称:", prop: "classifyName" }, { default: s(() => [d(I(e.value.classifyName), 1)]), _: 1 }), t(u, { label: "密度:", prop: "density" }, { default: s(() => [t(x, { modelValue: e.value.density, "onUpdate:modelValue": o[0] || (o[0] = (C) => e.value.density = C), controls: false, max: 999999, min: 0.01, precision: 5, class: "input-underline", "controls-position": "right", placeholder: "密度", size: "mini", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  T as default
};
