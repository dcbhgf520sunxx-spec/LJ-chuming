import { resolveComponent as i } from "vue";
import { openBlock as f } from "vue";
import { createBlock as g } from "vue";
import { withCtx as s } from "vue";
import { createVNode as e } from "vue";
import { unref as n } from "vue";
import { isRef as h } from "vue";
import { ElTableColumn as _ } from "element-plus";
import { u as w } from "../../../../../../shared/runtime.js";
const y = { __name: "nesting-detail", props: { visible: { type: Boolean, default: false }, detailList: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(t, { emit: c }) {
  const d = c, r = t, { visible: l, handleClose: m } = w({ emit: d, props: r, field: "visible" });
  return (v, a) => {
    const o = _, p = i("common-table"), u = i("common-dialog");
    return f(), g(u, { title: "排产明细", customClass: "nesting-detail-dialog", modelValue: n(l), "onUpdate:modelValue": a[0] || (a[0] = (b) => h(l) ? l.value = b : null), "close-on-click-modal": false, width: "800px", "before-close": n(m) }, { default: s(() => [e(p, { data: t.detailList, "max-height": 550, style: { width: "100%" } }, { default: s(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { prop: "orderNumber", "show-overflow-tooltip": "", label: "工单号", align: "center", "min-width": "240px" }), e(o, { prop: "schedulingQuantity", "show-overflow-tooltip": "", label: "数量", align: "center" }), e(o, { prop: "schedulingDate", "show-overflow-tooltip": "", label: "排产日期", align: "center" }), e(o, { prop: "schedulingUserName", "show-overflow-tooltip": "", label: "排产人", align: "center" })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  y as default
};
