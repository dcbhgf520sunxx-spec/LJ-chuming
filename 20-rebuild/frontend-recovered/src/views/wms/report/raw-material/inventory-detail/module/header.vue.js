import u from "moment";
import { ref as b } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as m } from "vue";
import { createVNode as r } from "vue";
import { withCtx as O } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as w } from "vue";
import { ElDatePicker as C } from "element-plus";
import { B as k, cO as v, pA as h, pz as V, gF as A, ap as I, C as x, E as T } from "../../../../../../shared/runtime.js";
const D = { class: "head-container" }, Q = { key: 0 }, H = { __name: "header", setup(S) {
  const i = [u().startOf("month").valueOf(), u().valueOf()], o = b(i), y = { times: i, classifyId: void 0, workshopIds: [] }, { crud: n, query: l, CRUD: p } = k(y);
  return p.HOOK.beforeResetQuery = () => {
    o.value = i;
  }, p.HOOK.beforeToQuery = () => {
    l.times = [o.value[0], u(parseInt(o.value[1])).endOf("month").valueOf()];
  }, p.HOOK.handleRefresh = async (g, { data: t }) => {
    await v(t.content, { multipleSpec: true });
    for (const e of t.content) {
      e.multipleSpec = Array.isArray(e.specifications) && e.specifications.length > 1;
      const a = [], c = { basicClass: e.basicClass, thickness: e.thickness, width: e.width, length: e.length, color: e.color };
      if (Array.isArray(e.specifications)) for (const d of e.specifications) {
        c.specification = d;
        const _ = h(c);
        a.push(_);
      }
      else {
        const d = h(c);
        a.push(d);
      }
      e.formatSpecArr = a, e.sourceFormatSpecArr = [...a], e.specTip = V({ ...c, specificationLabels: e.specificationLabels });
    }
  }, (g, t) => {
    const e = C;
    return f(), m("div", D, [r(s(T), null, { optLeft: O(() => [s(n).searchToggle ? (f(), m("div", Q, [r(e, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => o.value = a), clearable: false, disabledDate: (a) => a.getTime() > Date.now(), editable: false, class: "filter-item", "end-placeholder": "结束月份", format: "YYYY-MM", "range-separator": ":", size: "default", "start-placeholder": "开始月份", style: { width: "200px" }, type: "monthrange", "value-format": "x", onChange: s(n).toQuery }, null, 8, ["modelValue", "disabledDate", "onChange"]), r(A, { modelValue: s(l).workshopIds, "onUpdate:modelValue": t[1] || (t[1] = (a) => s(l).workshopIds = a), class: "filter-item", clearable: "", multiple: "", placeholder: "请选择仓库", style: { width: "240px" }, onChange: s(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(I, { modelValue: s(l).classifyId, "onUpdate:modelValue": t[2] || (t[2] = (a) => s(l).classifyId = a), "check-strictly": "", class: "filter-item", clearable: "", multiple: "", placeholder: "可选择/输入科目、编号搜索", separator: " > ", "show-all-levels": "", size: "default", style: { width: "300px" }, onChange: s(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(s(x))])) : w("", true)]), _: 1 })]);
  };
} };
export {
  H as default
};
