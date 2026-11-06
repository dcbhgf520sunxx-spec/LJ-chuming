import { ref as r } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as S } from "vue";
import { createBlock as R } from "vue";
import { withCtx as o } from "vue";
import { createVNode as l } from "vue";
import { createTextVNode as B } from "vue";
import { unref as d } from "vue";
import { ElMessage as C } from "element-plus";
import { ElInput as E } from "element-plus";
import { ElFormItem as F } from "element-plus";
import { ElForm as z } from "element-plus";
import { a as I } from "../../../../../modules/behavior-scoring-beef2568.js";
import { u as N, c9 as j } from "../../../../../shared/runtime.js";
const L = { __name: "add-score", props: { visible: { type: Boolean, default: false }, currentRowData: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(f, { emit: p }) {
  const i = p, n = f, e = r(), t = r({ behaviorTotalScore: void 0 }), { visible: v, handleClose: c } = N({ emit: i, props: n, field: "visible", showHook: _, closeHook: h }), u = r(false), b = { behaviorTotalScore: [{ required: true, message: "请输入年度行为总分", trigger: "blur" }, { pattern: j, message: "总分必须大于0", trigger: "blur" }] };
  function _() {
  }
  async function g() {
    try {
      if (u.value = true, !await e.value.validate()) return false;
      await I({ ...t.value, rosterId: n.currentRowData.id }), c(), i("success"), C.success("保存成功！");
    } catch (s) {
      console.log(s);
    } finally {
      u.value = false;
    }
  }
  function h() {
    e.value && e.value.resetFields(), e.value && e.value.clearValidate();
  }
  return (s, a) => {
    const w = m("common-button"), y = E, V = F, k = z, x = m("common-dialog");
    return S(), R(x, { "append-to-body": "", "close-on-click-modal": false, "before-close": d(c), visible: d(v), title: "增加年度行为总分", width: "550px" }, { titleRight: o(() => [l(w, { type: "success", size: "default", onClick: g }, { default: o(() => a[1] || (a[1] = [B("保存")])), _: 1, __: [1] })]), default: o(() => [l(k, { ref_key: "formRef", ref: e, model: t.value, rules: b, size: "default", "label-width": "150px" }, { default: o(() => [l(V, { label: "年度行为总分", prop: "behaviorTotalScore" }, { default: o(() => [l(y, { modelValue: t.value.behaviorTotalScore, "onUpdate:modelValue": a[0] || (a[0] = (T) => t.value.behaviorTotalScore = T), clearable: "", oninput: "value=value.replace(/[^\\d.]/g, '').replace(/\\./g,'')", placeholder: "请输入年度行为总分", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  L as default
};
