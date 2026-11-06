import { inject as D } from "vue";
import { ref as u } from "vue";
import { onMounted as C } from "vue";
import { watch as x } from "vue";
import { resolveComponent as k } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as p } from "vue";
import { createBlock as m } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as f } from "vue";
import { withDirectives as N } from "vue";
import { createTextVNode as V } from "vue";
import { unref as B } from "vue";
import { createVNode as d } from "vue";
import { ElNotification as S } from "element-plus";
import { ElFormItem as j } from "element-plus";
import { ElForm as z } from "element-plus";
import { ElCard as F } from "element-plus";
import { k as I } from "../../../../../modules/base-6bc46ddf.js";
import { fk as _, cy as P } from "../../../../../shared/runtime.js";
const T = { class: "clearfix" }, R = { __name: "deep_pen_config", setup(U) {
  const v = D("permission"), s = u([]), n = u([]), c = u(false), i = u(true);
  C(() => {
    _().then((t) => {
      s.value = r(t, (e) => e.isDeepen === true), n.value = r(t, (e) => e.isDeepen === true);
    });
  }), x(() => s.value, (t) => {
    t.length === n.value.length && t.sort().toString() === n.value.sort().toString() ? i.value = true : i.value = false;
  }, { deep: true });
  async function g() {
    c.value = true;
    try {
      const t = s.value.length > 0 ? s.value : [null];
      await I(t) && (S({ title: "部门任务|深化负责人员配置成功", type: "success", duration: 2500 }), _().then((o) => {
        n.value = r(o, (a) => a.isDeepen === true);
      }), i.value = true);
    } catch (t) {
      console.log("部门任务|深化负责人员配置", t);
    } finally {
      c.value = false;
    }
  }
  function r(t, e, o = []) {
    for (const a of t) e(a) && o.push(a.id), a.children && r(a.children, e, o);
    return o;
  }
  return (t, e) => {
    const o = k("common-tip-button"), a = j, h = z, b = F, y = E("permission");
    return p(), m(b, { shadow: "always" }, { header: l(() => [f("div", T, [e[2] || (e[2] = f("span", { class: "card-title" }, "部门任务|深化负责人员配置", -1)), N((p(), m(o, { loading: c.value, disabled: i.value, "show-tip": "", size: "mini", type: "primary", style: { float: "right" }, onClick: g }, { default: l(() => e[1] || (e[1] = [V(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[y, B(v).deepPenConfigEdit]])])]), default: l(() => [d(h, { model: s.value }, { default: l(() => [d(a, { label: "深化负责人", prop: "id " }, { default: l(() => [d(P, { modelValue: s.value, "onUpdate:modelValue": e[0] || (e[0] = (w) => s.value = w), filterable: "", "collapse-tags": false, clearable: "", multiple: "", "show-all-levels": "", style: { width: "100%" }, placeholder: "请选择深化负责人" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 });
  };
} };
export {
  R as default
};
