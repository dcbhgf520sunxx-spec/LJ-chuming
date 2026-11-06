import { resolveComponent as r } from "vue";
import { openBlock as x } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as B } from "vue";
import { createElementVNode as n } from "vue";
import { toDisplayString as i } from "vue";
import { unref as m } from "vue";
import { isRef as C } from "vue";
import { ElMessageBox as N } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { _ as k, u as D } from "../../../../../shared/runtime.js";
const T = { __name: "binding-detail", props: { visible: { type: Boolean, default: false }, detailList: { type: Object, default: () => {
} } }, emits: ["update:visible", "delete"], setup(s, { emit: f }) {
  const c = f, b = s, { visible: d, handleClose: p } = D({ emit: c, props: b, field: "visible", showHook: _ });
  function _() {
  }
  function g() {
    N.confirm("确定解除绑定吗", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false }).then(async () => {
      c("delete"), p();
    }).catch(() => {
    });
  }
  return (j, a) => {
    const h = r("common-button"), o = V, w = r("common-table"), v = r("common-dialog");
    return x(), y(v, { title: "绑定明细表", customClass: "binding-detail-dialog", modelValue: m(d), "onUpdate:modelValue": a[0] || (a[0] = (e) => C(d) ? d.value = e : null), "close-on-click-modal": false, width: "1200px", showClose: true, "before-close": m(p) }, { titleRight: l(() => [t(h, { type: "danger", disabled: !s.detailList.length, onClick: g }, { default: l(() => a[1] || (a[1] = [B(" 解除绑定 ")])), _: 1, __: [1] }, 8, ["disabled"])]), default: l(() => [t(w, { data: s.detailList, "max-height": 550, style: { width: "100%" }, id: "listTablesBinding" }, { default: l(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { prop: "classifyName", "show-overflow-tooltip": true, label: "物料种类", align: "center" }), t(o, { prop: "specification", "show-overflow-tooltip": true, label: "材质", align: "center" }), t(o, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: l(({ row: e }) => [n("span", null, i(e.addNumber), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "weight", label: "重量(kg)", align: "center" }, { default: l(({ row: e }) => [n("span", null, i(Math.round(e.addNumber * e.oneWeight / 1e3)), 1)]), _: 1 }), t(o, { prop: "brand", "show-overflow-tooltip": true, label: "品牌", align: "center" }), t(o, { prop: "heatNoAndBatchNo", "show-overflow-tooltip": true, label: "炉批号", align: "center" }), t(o, { prop: "projectName", "show-overflow-tooltip": true, label: "属实项目", align: "center" }, { default: l(({ row: e }) => {
      var u;
      return [n("span", null, i(((u = e == null ? void 0 : e.project) == null ? void 0 : u.name) || "-"), 1)];
    }), _: 1 }), t(o, { prop: "warehouse", "show-overflow-tooltip": true, label: "库位", align: "center" }, { default: l(({ row: e }) => [n("span", null, i(e.warehouse.name), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, H = k(T, [["__scopeId", "data-v-a476e92f"]]);
export {
  H as default
};
