import { resolveComponent as w } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as l } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as b } from "element-plus";
import { _ as y, t as h, o as g, bV as c, p as v, ba as k } from "../../../../../shared/runtime.js";
const P = { class: "app-container" }, x = { __name: "part", setup(N) {
  const { decimalPrecision: i } = h(), s = [{ projectNumber: "11111", projectName: "项目", serialNumber: "GL-3", specification: "BH400*200*6*9", interfaceType: ">400<500", nuclear: "米", totalMete: 200, unitPrice: 10, totalPrice: "200", productionDate: 16543e5 }], { maxHeight: u } = g({ paginate: true, extraHeight: 40 });
  function m(p) {
    return k(p, { props: ["totalMete", ["totalPrice", i.value.mes]] });
  }
  return (p, T) => {
    const o = b, _ = w("common-table");
    return f(), d("div", P, [t(_, { ref: "tableRef", data: s, "max-height": n(u), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": m }, { default: a(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "项目" }, { default: a((e) => [r("span", null, l(e.row.serialNumber) + "-" + l(e.row.projectName), 1)]), _: 1 }), t(o, { key: "cutType", prop: "cutType", "show-overflow-tooltip": true, label: "切割方式", align: "center" }, { default: a((e) => [r("span", null, l(e.row.cutType), 1)]), _: 1 }), t(o, { key: "materialType", prop: "materialType", "show-overflow-tooltip": true, label: "原材料类型", align: "center" }, { default: a((e) => [r("span", null, l(e.row.materialType), 1)]), _: 1 }), t(o, { key: "interfaceSpec", prop: "interfaceSpec", "show-overflow-tooltip": true, label: "截面规格", align: "center" }, { default: a((e) => [r("span", null, l(e.row.interfaceSpec), 1)]), _: 1 }), t(o, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", align: "center" }, { default: a((e) => [r("span", null, l(e.row.serialNumber), 1)]), _: 1 }), t(o, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", align: "center" }, { default: a((e) => [r("span", null, l(e.row.specification), 1)]), _: 1 }), t(o, { key: "nuclear", prop: "nuclear", "show-overflow-tooltip": true, label: "核算单位", align: "center" }, { default: a((e) => [r("span", null, l(e.row.nuclear), 1)]), _: 1 }), t(o, { key: "totalMete", prop: "totalMete", "show-overflow-tooltip": true, label: "生产量", align: "center" }, { default: a((e) => [r("span", null, l(e.row.totalMete), 1)]), _: 1 }), t(o, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": true, label: "单价", align: "center" }, { default: a((e) => [r("span", null, l(e.row.unitPrice ? n(c)(e.row.unitPrice, n(i).mes) : 0), 1)]), _: 1 }), t(o, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": true, label: "总额（元）", align: "center" }, { default: a((e) => [r("span", null, l(e.row.totalPrice ? n(c)(e.row.totalPrice, n(i).mes) : 0), 1)]), _: 1 }), t(o, { key: "productionDate", prop: "productionDate", "show-overflow-tooltip": true, label: "生产日期", align: "center" }, { default: a((e) => [r("span", null, l(e.row.productionDate ? n(v)(e.row.productionDate, "{y}/{m}/{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["max-height"])]);
  };
} }, M = y(x, [["__scopeId", "data-v-0b045960"]]);
export {
  M as default
};
