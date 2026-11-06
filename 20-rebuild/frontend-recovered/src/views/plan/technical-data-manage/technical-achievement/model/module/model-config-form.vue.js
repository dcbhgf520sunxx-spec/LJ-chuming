import { ref as p } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as B } from "vue";
import { createBlock as I } from "vue";
import { withCtx as t } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as O } from "vue";
import { createElementVNode as b } from "vue";
import { toDisplayString as V } from "vue";
import { unref as d } from "vue";
import { isRef as U } from "vue";
import { ElNotification as h } from "element-plus";
import { ElFormItem as z } from "element-plus";
import { ElForm as T } from "element-plus";
import { r as j } from "../../../../../../modules/model-0ac957f7.js";
import { u as q, r as c, tr as F } from "../../../../../../shared/runtime.js";
const L = { __name: "model-config-form", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} }, modelType: { type: String, default: "monomer" } }, emits: ["update:visible", "success"], setup(r, { emit: y }) {
  const _ = y, i = r, { visible: u, handleClose: g } = q({ emit: _, props: i, field: "visible", showHook: E }), v = p(), n = p({ importMode: c.MONOMER.V, edition: void 0 }), f = p(false), M = { importMode: [{ required: true, message: "请选择上传模式", trigger: "change" }], edition: [{ required: true, message: "请选择模型版本号", trigger: "change" }] };
  function E() {
    var a, e;
    n.value = { importMode: ((a = i.info) == null ? void 0 : a.importMode) || c.MONOMER.V, edition: ((e = i.info) == null ? void 0 : e.edition) || void 0 };
  }
  function N() {
    v.value.validate(async (a) => {
      if (a) try {
        f.value = true, await j({ ...n.value, monomerId: i.info.id }), h({ title: "模型配置", type: "success", message: "修改配置成功", duration: 2500 }), _("success"), g();
      } catch (e) {
        console.log("模型配置失败", e);
      } finally {
        f.value = false;
      }
    });
  }
  return (a, e) => {
    const k = m("common-button"), s = z, x = m("common-radio"), w = m("common-select"), C = T, R = m("common-dialog");
    return B(), I(R, { title: "模型配置", modelValue: d(u), "onUpdate:modelValue": e[2] || (e[2] = (o) => U(u) ? u.value = o : null), width: "450px", "before-close": d(g) }, { titleRight: t(() => [l(k, { loading: f.value, size: "default", type: "primary", onClick: N }, { default: t(() => e[3] || (e[3] = [O("保存")])), _: 1, __: [3] }, 8, ["loading"])]), default: t(() => [l(C, { ref_key: "formRef", ref: v, size: "default", model: n.value, rules: M, "label-width": "120px" }, { default: t(() => [l(s, { label: "所属项目" }, { default: t(() => [b("span", null, V(r.info.projectName), 1)]), _: 1 }), l(s, { label: "单体" }, { default: t(() => {
      var o;
      return [b("span", null, V((o = r.info) == null ? void 0 : o.name), 1)];
    }), _: 1 }), l(s, { label: "上传模式", prop: "importMode" }, { default: t(() => [l(x, { modelValue: n.value.importMode, "onUpdate:modelValue": e[0] || (e[0] = (o) => n.value.importMode = o), options: d(c).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(s, { label: "模型版本号", prop: "edition" }, { default: t(() => [l(w, { modelValue: n.value.edition, "onUpdate:modelValue": e[1] || (e[1] = (o) => n.value.edition = o), options: d(F).ENUM, type: "enum", size: "default", style: { width: "200px" }, placeholder: "Tekla版本" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  L as default
};
