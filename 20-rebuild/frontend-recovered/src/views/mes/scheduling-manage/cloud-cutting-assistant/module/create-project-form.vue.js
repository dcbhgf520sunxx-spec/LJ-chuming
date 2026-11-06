import { ref as u } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as N } from "vue";
import { createBlock as x } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as B } from "vue";
import { unref as d } from "vue";
import { isRef as C } from "vue";
import { ElNotification as E } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElInput as j } from "element-plus";
import { ElForm as z } from "element-plus";
import { u as U, aV as q } from "../../../../../shared/runtime.js";
import { i as F } from "../../../../../modules/cloud-cutting-assistant-43dc84e4.js";
const M = { __name: "create-project-form", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible", "refresh"], setup(v, { emit: _ }) {
  const m = _, i = u(), r = u(false), b = v, { visible: n, handleClose: c } = U({ emit: m, props: b, field: "visible", showHook: g }), o = u({ workshopId: void 0, cloudcutName: void 0 });
  async function g() {
    var l;
    o.value = {}, await ((l = i.value) == null ? void 0 : l.clearValidate());
  }
  const w = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], cloudcutName: [{ required: true, message: "请填写项目名称且不多于20个字符", max: 20, trigger: "blur" }] };
  async function h() {
    try {
      await i.value.validate() && (r.value = true, await F({ ...o.value }), E({ title: "新增成功", type: "success" }), c(), m("refresh"));
    } catch (l) {
      console.log("新增失败", l);
    } finally {
      r.value = false;
    }
  }
  return (l, e) => {
    const y = p("common-button"), f = R, V = j, k = z, I = p("common-dialog");
    return N(), x(I, { "append-to-body": "", "close-on-click-modal": false, "before-close": d(c), visible: d(n), "onUpdate:visible": e[2] || (e[2] = (s) => C(n) ? n.value = s : null), title: "创建项目", width: "500px" }, { titleRight: a(() => [t(y, { loading: r.value, type: "primary", size: "default", onClick: h }, { default: a(() => e[3] || (e[3] = [B("保存")])), _: 1, __: [3] }, 8, ["loading"])]), default: a(() => [t(k, { ref_key: "formRef", ref: i, model: o.value, rules: w, size: "default", "label-width": "70px" }, { default: a(() => [t(f, { label: "车间", prop: "workshopId" }, { default: a(() => [t(d(q), { modelValue: o.value.workshopId, "onUpdate:modelValue": e[0] || (e[0] = (s) => o.value.workshopId = s), placeholder: "选择车间", clearable: "", style: { width: "100%" }, class: "filter-item" }, null, 8, ["modelValue"])]), _: 1 }), t(f, { label: "项目", prop: "cloudcutName" }, { default: a(() => [t(V, { modelValue: o.value.cloudcutName, "onUpdate:modelValue": e[1] || (e[1] = (s) => o.value.cloudcutName = s), modelModifiers: { trim: true }, placeholder: "填写名称", style: { width: "100%" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  M as default
};
