import { ref as h } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as D } from "vue";
import { createBlock as V } from "vue";
import { withCtx as l } from "vue";
import { createVNode as n } from "vue";
import { unref as e } from "vue";
import { createTextVNode as w } from "vue";
import { ElMessage as x } from "element-plus";
import { ElInput as E } from "element-plus";
import { ElFormItem as k } from "element-plus";
import { ElForm as C } from "element-plus";
import { b as F, s as U } from "../../../../../modules/behavior-scoring-beef2568.js";
import { ao as B, o1 as I, c9 as N } from "../../../../../shared/runtime.js";
const M = { __name: "scoring-config", setup(z) {
  const s = h(), d = { boolDeduction: void 0, totalScore: void 0 }, { crud: r, form: t } = B(d, s), m = { boolDeduction: [{ required: true, message: "请选择是否扣减", trigger: "change" }], totalScore: [{ required: true, message: "请输入年度行为总分", trigger: "change" }, { pattern: N, message: "总分必须大于0", trigger: "blur" }] };
  function p() {
    f();
  }
  async function f() {
    try {
      const o = await F();
      t.boolDeduction = o == null ? void 0 : o.boolDeduction, t.totalScore = (o == null ? void 0 : o.totalScore) || void 0;
    } catch (o) {
      console.log(o);
    }
  }
  async function _() {
    try {
      if (!await s.value.validate()) return false;
      await U(t), r.cancelCU(), x.success("保存成功！"), r.refresh();
    } catch (o) {
      console.log(o);
    }
  }
  return (o, a) => {
    const g = u("common-button"), b = E, i = k, v = u("common-radio"), y = C, S = u("common-dialog");
    return D(), V(S, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, onOpen: p, title: "行为总分", width: "550px" }, { titleRight: l(() => [n(g, { loading: e(r).status.cu === 2, type: "success", size: "default", onClick: _ }, { default: l(() => a[2] || (a[2] = [w("保存")])), _: 1, __: [2] }, 8, ["loading"])]), default: l(() => [n(y, { ref_key: "formRef", ref: s, model: e(t), rules: m, size: "default", "label-width": "150px" }, { default: l(() => [n(i, { label: "年度行为总分", prop: "totalScore" }, { default: l(() => [n(b, { modelValue: e(t).totalScore, "onUpdate:modelValue": a[0] || (a[0] = (c) => e(t).totalScore = c), clearable: "", oninput: "value=value.replace(/[^\\d.]/g, '').replace(/\\./g,'')", placeholder: "请输入年度行为总分", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), n(i, { label: "新员工自动扣减", prop: "boolDeduction" }, { default: l(() => [n(v, { modelValue: e(t).boolDeduction, "onUpdate:modelValue": a[1] || (a[1] = (c) => e(t).boolDeduction = c), options: e(I).ENUM, type: "enum" }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible"]);
  };
} };
export {
  M as default
};
