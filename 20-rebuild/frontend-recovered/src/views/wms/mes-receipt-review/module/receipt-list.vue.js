import { ref as p } from "vue";
import { resolveComponent as r } from "vue";
import { openBlock as x } from "vue";
import { createBlock as V } from "vue";
import { withCtx as a } from "vue";
import { createVNode as e } from "vue";
import { unref as c } from "vue";
import { isRef as C } from "vue";
import { ElTableColumn as R } from "element-plus";
import { ElPopconfirm as j } from "element-plus";
import { u as M } from "../../../../shared/runtime.js";
const U = { __name: "receipt-list", props: { visible: { type: Boolean, require: true }, list: { type: Array, default: () => [] }, maxHeight: { type: Number, default: 100 } }, emits: ["success", "update:visible", "update:modelValue", "deleteReceipt"], setup(t, { emit: m }) {
  const s = m, d = t, u = p(), f = p([["project", "parse-project"]]), { visible: i, handleClose: b } = M({ emit: s, props: d });
  function h(g, l) {
    s("deleteReceipt", l);
  }
  return (g, l) => {
    const o = R, w = r("common-button"), y = j, _ = r("common-table"), k = r("common-dialog");
    return x(), V(k, { ref_key: "dialogRef", ref: u, modelValue: c(i), "onUpdate:modelValue": l[0] || (l[0] = (n) => C(i) ? i.value = n : null), "before-close": c(b), "show-close": true, top: "3vh", width: "1000px", title: "本次选择工单" }, { default: a(() => [e(_, { data: t.list, "max-height": t.maxHeight - 150, "row-key": "id", "data-format": f.value, "show-empty-symbol": false, "return-source-data": "" }, { default: a(() => [e(o, { prop: "index", label: "序号", align: "center", width: "55", type: "index" }), e(o, { key: "project", prop: "project", label: "项目", "show-overflow-tooltip": "", align: "right", "min-width": "150" }), e(o, { key: "mesWorkshop.name", prop: "mesWorkshop.name", "show-overflow-tooltip": "", label: "车间", align: "right" }), e(o, { key: "taskOrderNumber", prop: "taskOrderNumber", "show-overflow-tooltip": "", label: "工单号", align: "right", "min-width": "120" }), e(o, { key: "materialType", prop: "materialType", "show-overflow-tooltip": "", label: "物料种类", align: "center" }), e(o, { key: "accountingUnit", prop: "accountingUnit", "show-overflow-tooltip": "", label: "单位", align: "right", width: "80px" }), e(o, { key: "pickingMete", prop: "pickingMete", "show-overflow-tooltip": "", label: "领料量", align: "right" }), e(o, { key: "outboundMete", prop: "outboundMete", "show-overflow-tooltip": "", label: "已办理", align: "right" }), e(o, { label: "操作", width: "120px", align: "left" }, { default: a(({ row: n, $index: v }) => [e(y, { "confirm-button-text": "确定", "cancel-button-text": "取消", "icon-color": "red", title: "确定删除吗?", onConfirm: (N) => h(n, v) }, { reference: a(() => [e(w, { icon: "el-icon-delete", size: "default", type: "danger", disabled: t.list.length === 1 }, null, 8, ["disabled"])]), _: 2 }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "data-format"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  U as default
};
