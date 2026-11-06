import { resolveComponent as c } from "vue";
import { openBlock as B } from "vue";
import { createBlock as k } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as C } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as n } from "vue";
import { unref as b } from "vue";
import { isRef as N } from "vue";
import { ElMessageBox as T } from "element-plus";
import { ElTableColumn as V } from "element-plus";
import { ElImage as D } from "element-plus";
import { ElTooltip as $ } from "element-plus";
import { _ as j, u as E } from "../../../../../shared/runtime.js";
const P = { __name: "binding-detail", props: { visible: { type: Boolean, default: false }, detailList: { type: Object, default: () => {
} } }, emits: ["update:visible", "delete"], setup(s, { emit: _ }) {
  const p = _, f = s, { visible: r, handleClose: d } = E({ emit: p, props: f, field: "visible", showHook: h });
  function h() {
  }
  function g() {
    T.confirm("确定解除绑定吗", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false }).then(async () => {
      p("delete"), d();
    }).catch(() => {
    });
  }
  return (H, i) => {
    const w = c("common-button"), l = V, u = D, v = $, y = c("common-table"), x = c("common-dialog");
    return B(), k(x, { title: "绑定明细表", customClass: "binding-detail-dialog", modelValue: b(r), "onUpdate:modelValue": i[0] || (i[0] = (e) => N(r) ? r.value = e : null), "close-on-click-modal": false, width: "1200px", showClose: true, "before-close": b(d) }, { titleRight: o(() => [t(w, { size: "default", type: "danger", disabled: !s.detailList.length, onClick: g }, { default: o(() => i[1] || (i[1] = [C(" 解除绑定 ")])), _: 1, __: [1] }, 8, ["disabled"])]), default: o(() => [t(y, { data: s.detailList, "max-height": 550, style: { width: "100%" }, id: "listTablesBinding" }, { default: o(() => [t(l, { label: "序号", type: "index", align: "center", width: "60" }), t(l, { prop: "classifyName", "show-overflow-tooltip": true, label: "物料种类", align: "center" }), t(l, { prop: "specification", "show-overflow-tooltip": true, label: "材质", align: "center" }), t(l, { prop: "thickness", label: "厚度(mm)", align: "center" }), t(l, { key: "material", prop: "material", label: "规格", align: "center", width: "120px" }, { default: o(({ row: e }) => [a("span", null, n(`${e.length} * ${e.width}`), 1)]), _: 1 }), t(l, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: o(({ row: e }) => [a("span", null, n(e.addNumber), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "weight", label: "重量(kg)", align: "center" }, { default: o(({ row: e }) => [a("span", null, n(Math.round(e.addNumber * e.oneWeight / 1e3)), 1)]), _: 1 }), t(l, { "show-overflow-tooltip": true, prop: "area", label: "单张面积(m²)", align: "center" }, { default: o(({ row: e }) => [a("span", null, n(`${(e.length / 1e3 * (e.width / 1e3)).toFixed(2)}`), 1)]), _: 1 }), t(l, { prop: "brand", "show-overflow-tooltip": true, label: "品牌", align: "center" }), t(l, { prop: "heatNoAndBatchNo", "show-overflow-tooltip": true, label: "炉批号", align: "center" }), t(l, { key: "picturePath", prop: "picturePath", label: "缩略图", align: "center" }, { default: o(({ row: e }) => [t(v, { placement: "top", effect: "light", ref: "tooltip", "show-after": 200 }, { content: o(() => [t(u, { style: { width: "200px", height: "200px" }, fit: "scale-down", "scroll-container": "#listTablesBinding .el-table__body-wrapper", src: `${e.picturePath}` }, null, 8, ["src"])]), default: o(() => [t(u, { style: { width: "100%", height: "20px" }, lazy: "", fit: "scale-down", "scroll-container": "#listTablesBinding .el-table__body-wrapper", src: `${e.picturePath}` }, null, 8, ["src"])]), _: 2 }, 1536)]), _: 1 }), t(l, { prop: "projectName", "show-overflow-tooltip": true, label: "属实项目", align: "center" }, { default: o(({ row: e }) => {
      var m;
      return [a("span", null, n(((m = e == null ? void 0 : e.project) == null ? void 0 : m.name) || "-"), 1)];
    }), _: 1 }), t(l, { prop: "warehouse", "show-overflow-tooltip": true, label: "库位", align: "center" }, { default: o(({ row: e }) => [a("span", null, n(e.warehouse.name), 1)]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, M = j(P, [["__scopeId", "data-v-e4a8bbd6"]]);
export {
  M as default
};
