import { computed as R } from "vue";
import { ref as n } from "vue";
import { watch as U } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as I } from "vue";
import { createBlock as F } from "vue";
import { withCtx as s } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as g } from "vue";
import { unref as r } from "vue";
import d from "moment";
import { ElNotification as h } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElFormItem as L } from "element-plus";
import { ElDatePicker as S } from "element-plus";
import { ElForm as j } from "element-plus";
import { u as q } from "../../../../../../shared/runtime.js";
import { h as A } from "../../../../../../modules/inventory-analysis-usage-4b0f952d.js";
const J = { __name: "manual-balance", props: { visible: { type: Boolean, default: false }, statisticsDate: { type: Array, default: () => [] } }, emits: ["update:visible", "handleStatisticsDate"], setup(D, { emit: V }) {
  const f = V, m = D, x = R(() => "结存模式"), { visible: p, handleClose: v } = q({ emit: f, props: m, field: "visible", showHook: E }), b = n(false), u = n(false), k = (a) => {
    var i;
    const e = d((i = m.statisticsDate[0]) == null ? void 0 : i.startTime).startOf("day"), c = d().subtract(1, "day").endOf("day");
    return a < e || a > c;
  }, _ = n(), z = { endTime: [{ required: true, message: "请选择本次结存结束时间", trigger: "change" }] }, t = n({ startTime: void 0, endTime: void 0, name: void 0 });
  function E() {
    B();
  }
  async function B() {
    try {
      b.value = true;
    } catch (a) {
      console.error(a);
    } finally {
      b.value = false;
    }
  }
  async function C() {
    u.value = true;
    try {
      await _.value.validate();
      const a = { endTime: Number(t.value.endTime), name: t.value.name };
      await A(a), h({ title: "报表中心配置设置成功", type: "success", duration: 2500 }), v(), t.value = {}, f("handleStatisticsDate");
    } catch {
      h({ title: "报表中心配置设置失败", type: "error", duration: 2500 });
    } finally {
      u.value = false;
    }
  }
  return U(() => p, () => {
    var a;
    t.value.startTime = (a = m.statisticsDate[0]) == null ? void 0 : a.startTime;
  }, { immediate: true, deep: true }), (a, e) => {
    const c = T("common-tip-button"), i = H, y = L, w = S, N = j, O = T("common-dialog");
    return I(), F(O, { ref: "drawerRef", "before-close": r(v), "close-on-click-modal": false, "close-on-press-escape": false, title: x.value, visible: r(p), "custom-class": "raw-mat-send-and-receive-storage-balance-mode", "show-close": "", width: "40%" }, { titleRight: s(() => [o(c, { loading: u.value, class: "filter-item", "show-tip": "", size: "default", type: "primary", onClick: C }, { default: s(() => e[3] || (e[3] = [g(" 保存 ")])), _: 1, __: [3] }, 8, ["loading"])]), default: s(() => [o(N, { ref_key: "formRef", ref: _, model: t.value, rules: z, "label-width": "150px" }, { default: s(() => [o(y, { label: "本次结存名称：", prop: "name" }, { default: s(() => [o(i, { modelValue: t.value.name, "onUpdate:modelValue": e[0] || (e[0] = (l) => t.value.name = l), modelModifiers: { trim: true }, class: "filter-item", clearable: "", placeholder: "请输入本次结存名称", size: "default", style: { width: "200px" } }, null, 8, ["modelValue"])]), _: 1 }), o(y, { label: "本次结存日期：", prop: "endTime" }, { default: s(() => [o(w, { modelValue: t.value.startTime, "onUpdate:modelValue": e[1] || (e[1] = (l) => t.value.startTime = l), disabled: true, disabledDate: (l) => r(d)(l).valueOf() < r(d)().subtract(1, "days").valueOf(), class: "filter-item", placeholder: "请选择本次结存开始日期", size: "default", style: { width: "240px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue", "disabledDate"]), e[4] || (e[4] = g(" ： ")), o(w, { modelValue: t.value.endTime, "onUpdate:modelValue": e[2] || (e[2] = (l) => t.value.endTime = l), disabledDate: k, class: "filter-item", placeholder: "请选择本次结存结束日期", size: "default", style: { width: "240px" }, type: "date", "value-format": "x" }, null, 8, ["modelValue"])]), _: 1, __: [4] })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} };
export {
  J as default
};
