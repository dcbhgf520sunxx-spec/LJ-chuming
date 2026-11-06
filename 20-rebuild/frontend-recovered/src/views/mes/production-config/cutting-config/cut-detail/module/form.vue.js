import { ref as u } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as x } from "vue";
import { createBlock as D } from "vue";
import { withCtx as t } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as I } from "vue";
import { unref as m } from "vue";
import { isRef as N } from "vue";
import { ElNotification as B } from "element-plus";
import { ElInputNumber as z } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElForm as U } from "element-plus";
import { u as j, au as q } from "../../../../../../shared/runtime.js";
import { a as F, e as $ } from "../../../../../../modules/unloading-config-b9decdaa.js";
const O = { __name: "form", props: { visible: { type: Boolean, default: false }, isEdit: { type: Boolean, default: false }, cutConfigId: { type: Number }, formData: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(d, { emit: g }) {
  const f = g, c = u(), p = u(false), o = d, { visible: s, handleClose: b } = j({ emit: f, props: o, field: "visible", showHook: v }), e = u({ id: void 0, thickness: void 0, boolDrillEnum: void 0 });
  function v() {
    o.isEdit ? e.value = o.formData : e.value = {};
  }
  const y = { thickness: [{ required: true, message: "请填写厚度", trigger: "blur" }], boolDrillEnum: [{ required: true, message: "请选择是否开孔", trigger: "blur" }] };
  async function E() {
    try {
      await c.value.validate() && (p.value = true, o.isEdit ? await $({ ...e.value, cutConfigId: o.cutConfigId }) : await F({ ...e.value, cutConfigId: o.cutConfigId }), B({ title: `${o.isEdit ? "编辑" : "新增"}成功`, type: "success" }), b(), f("refresh"));
    } catch (n) {
      console.log("切割详情配置失败", n);
    } finally {
      p.value = false;
    }
  }
  return (n, l) => {
    const h = r("common-button"), C = z, _ = R, V = r("common-select"), k = U, w = r("common-dialog");
    return x(), D(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": m(b), modelValue: m(s), "onUpdate:modelValue": l[2] || (l[2] = (a) => N(s) ? s.value = a : null), title: `${d.isEdit ? "编辑" : "新增"}切割详情`, width: "500px" }, { titleRight: t(() => [i(h, { type: "primary", size: "default", onClick: E }, { default: t(() => l[3] || (l[3] = [I("提交")])), _: 1, __: [3] })]), default: t(() => [i(k, { ref_key: "formRef", ref: c, model: e.value, rules: y, size: "default", "label-width": "100px" }, { default: t(() => [i(_, { label: "厚度：", prop: "thickness" }, { default: t(() => [i(C, { class: "filter-item", modelValue: e.value.thickness, "onUpdate:modelValue": l[0] || (l[0] = (a) => e.value.thickness = a), placeholder: "输入厚度", type: "text", "controls-position": "right", style: { width: "270px" }, min: 0, max: 999999999 }, null, 8, ["modelValue"])]), _: 1 }), i(_, { label: "是否开孔：", prop: "boolDrillEnum" }, { default: t(() => [i(V, { modelValue: e.value.boolDrillEnum, "onUpdate:modelValue": l[1] || (l[1] = (a) => e.value.boolDrillEnum = a), options: m(q).ENUM, type: "enum", clearable: "", size: "default", placeholder: "是否开孔", class: "filter-item", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue", "title"]);
  };
} };
export {
  O as default
};
