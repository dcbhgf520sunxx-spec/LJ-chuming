import { resolveComponent as f } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as r } from "vue";
import { unref as n } from "vue";
import { ElTableColumn as b } from "element-plus";
import { _ as h, t as y, o as g, bV as s, p as v, ba as x } from "../../../../../shared/runtime.js";
const P = { class: "app-container" }, k = { __name: "artifact", setup(N) {
  const { decimalPrecision: i } = y(), p = [{ projectNumber: "11111", projectName: "项目", serialNumber: "GL-3", specification: "BH400*200*6*9", interfaceType: ">400<500", nuclear: "米", totalMete: 200, unitPrice: 10, totalPrice: "200", productionDate: 16543e5 }], { maxHeight: u } = g({ paginate: true, extraHeight: 40 });
  function m(c) {
    return x(c, { props: ["totalMete", "totalPrice"] });
  }
  return (c, D) => {
    const o = b, _ = f("common-table");
    return d(), w("div", P, [t(_, { ref: "tableRef", data: p, "max-height": n(u), style: { width: "100%" }, "return-source-data": "", showEmptySymbol: false, "show-summary": "", "summary-method": m }, { default: a(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { key: "name", prop: "name", align: "center", "show-overflow-tooltip": true, label: "项目", "min-width": "100px" }, { default: a((e) => [l("span", null, r(e.row.projectNumber) + "-" + r(e.row.projectName), 1)]), _: 1 }), t(o, { key: "serialNumber", prop: "serialNumber", align: "center", "show-overflow-tooltip": true, label: "编号" }, { default: a((e) => [l("span", null, r(e.row.serialNumber), 1)]), _: 1 }), t(o, { key: "specification", prop: "specification", align: "center", "show-overflow-tooltip": true, label: "规格" }, { default: a((e) => [l("span", null, r(e.row.specification), 1)]), _: 1 }), t(o, { key: "interfaceType", prop: "interfaceType", align: "center", "show-overflow-tooltip": true, label: "截面类型" }, { default: a((e) => [l("span", null, r(e.row.interfaceType), 1)]), _: 1 }), t(o, { key: "nuclear", prop: "nuclear", align: "center", "show-overflow-tooltip": true, label: "核算单位" }, { default: a((e) => [l("span", null, r(e.row.nuclear), 1)]), _: 1 }), t(o, { key: "totalMete", prop: "totalMete", align: "center", "show-overflow-tooltip": true, label: "生产量" }, { default: a((e) => [l("span", null, r(e.row.totalMete), 1)]), _: 1 }), t(o, { key: "unitPrice", prop: "unitPrice", align: "center", "show-overflow-tooltip": true, label: "单价" }, { default: a((e) => [l("span", null, r(e.row.unitPrice ? n(s)(e.row.unitPrice, n(i).mes) : 0), 1)]), _: 1 }), t(o, { key: "totalPrice", prop: "totalPrice", align: "center", "show-overflow-tooltip": true, label: "总额（元）" }, { default: a((e) => [l("span", null, r(e.row.totalPrice ? n(s)(e.row.totalPrice, n(i).mes) : 0), 1)]), _: 1 }), t(o, { key: "productionDate", prop: "productionDate", align: "center", "show-overflow-tooltip": true, label: "生产日期" }, { default: a((e) => [l("span", null, r(e.row.productionDate ? n(v)(e.row.productionDate, "{y}/{m}/{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["max-height"])]);
  };
} }, j = h(k, [["__scopeId", "data-v-e2771529"]]);
export {
  j as default
};
