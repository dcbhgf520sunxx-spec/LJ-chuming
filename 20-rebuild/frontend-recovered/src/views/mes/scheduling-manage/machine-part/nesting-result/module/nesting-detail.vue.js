import { ref as b } from "vue";
import { resolveComponent as s } from "vue";
import { openBlock as g } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { unref as i } from "vue";
import { isRef as w } from "vue";
import { ElTableColumn as v } from "element-plus";
import { _ as x, u as y } from "../../../../../../shared/runtime.js";
const C = { __name: "nesting-detail", props: { visible: { type: Boolean, default: false }, detailList: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(l, { emit: c }) {
  b([]);
  const r = c, d = l, { visible: t, handleClose: u } = y({ emit: r, props: d, field: "visible", showHook: p });
  function p() {
  }
  return (V, a) => {
    const o = v, m = s("common-table"), _ = s("common-dialog");
    return g(), h(_, { title: "排产明细", customClass: "nesting-detail-dialog", modelValue: i(t), "onUpdate:modelValue": a[0] || (a[0] = (f) => w(t) ? t.value = f : null), "close-on-click-modal": false, width: "800px", showClose: true, "before-close": i(u) }, { default: n(() => [e(m, { data: l.detailList, "max-height": 550, style: { width: "100%" } }, { default: n(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "orderNumber", "show-overflow-tooltip": true, label: "工单号", align: "center" }), e(o, { prop: "schedulingQuantity", "show-overflow-tooltip": true, label: "数量", align: "center" }), e(o, { prop: "schedulingDate", "show-overflow-tooltip": true, label: "排产日期", align: "center" }), e(o, { prop: "schedulingUserName", "show-overflow-tooltip": true, label: "排产人", align: "center" })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, B = x(C, [["__scopeId", "data-v-330e20c0"]]);
export {
  B as default
};
