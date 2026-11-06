import { resolveComponent as f } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as t } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as o } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as b } from "element-plus";
import { _ as y, t as h, o as g, bV as p, ba as v } from "../../../../../shared/runtime.js";
const P = { class: "app-container" }, x = { __name: "perforate", setup(k) {
  const { decimalPrecision: i } = h(), s = [{ projectNumber: "11111", projectName: "项目", serialNumber: "GL-3", specification: "BH400*200*6*9", interfaceType: ">400<500", nuclear: "米", apertureQuantity: 12, totalMete: 200, unitPrice: 10, totalPrice: "200", productionDate: 16543e5 }], { maxHeight: c } = g({ paginate: true, extraHeight: 40 });
  function m(u) {
    return v(u, { props: ["apertureQuantity", ["totalPrice", i.value.mes]] });
  }
  return (u, N) => {
    const a = b, _ = f("common-table");
    return w(), d("div", P, [t(_, { ref: "tableRef", data: s, "max-height": n(c), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": m }, { default: r(() => [t(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(a, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目", align: "center" }, { default: r((e) => [l("span", null, o(e.row.serialNumber) + "-" + o(e.row.projectName), 1)]), _: 1 }), t(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }, { default: r((e) => [l("span", null, o(e.row.serialNumber), 1)]), _: 1 }), t(a, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center" }, { default: r((e) => [l("span", null, o(e.row.quantity), 1)]), _: 1 }), t(a, { key: "interfaceSpec", prop: "interfaceSpec", "show-overflow-tooltip": true, label: "截面类型", align: "center" }, { default: r((e) => [l("span", null, o(e.row.interfaceSpec), 1)]), _: 1 }), t(a, { key: "aperture", prop: "aperture", "show-overflow-tooltip": true, label: "孔径", align: "center" }, { default: r((e) => [l("span", null, o(e.row.aperture), 1)]), _: 1 }), t(a, { key: "apertureQuantity", prop: "apertureQuantity", "show-overflow-tooltip": true, label: "孔数量", align: "center" }, { default: r((e) => [l("span", null, o(e.row.apertureQuantity), 1)]), _: 1 }), t(a, { key: "nuclear", prop: "nuclear", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: r((e) => [l("span", null, o(e.row.nuclear), 1)]), _: 1 }), t(a, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": true, label: "单价", align: "center" }, { default: r((e) => [l("span", null, o(e.row.unitPrice ? n(p)(e.row.unitPrice, n(i).mes) : 0), 1)]), _: 1 }), t(a, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": true, label: "总额（元）", align: "center" }, { default: r((e) => [l("span", null, o(e.row.totalPrice ? n(p)(e.row.totalPrice, n(i).mes) : 0), 1)]), _: 1 })]), _: 1 }, 8, ["max-height"])]);
  };
} }, B = y(x, [["__scopeId", "data-v-44b20778"]]);
export {
  B as default
};
