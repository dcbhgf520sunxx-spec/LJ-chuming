import { computed as p } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as t } from "vue";
import { createBlock as e } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as w } from "vue";
import { normalizeStyle as d } from "vue";
import { toDisplayString as g } from "vue";
import { unref as r } from "vue";
import { createElementBlock as y } from "vue";
import { ElTableColumn as k } from "element-plus";
import { j as u } from "../../../../../modules/judgeSameValue-9683bdce.js";
import { i as n } from "../../../../../shared/runtime.js";
import { _ as f } from "../../../../../modules/index-61ce89a1.js";
const W = { key: 1 }, $ = { key: 1 }, v = { key: 1 }, D = { key: 1 }, N = { key: 1 }, S = { key: 1 }, x = { key: 1 }, T = { key: 1 }, q = { key: 1 }, B = { key: 1 }, I = { __name: "pressed-color-table", props: { tableData: { type: Array, default: () => [] }, originData: { type: Array, default: () => [] } }, setup(m) {
  const _ = m, c = p(() => {
    var V;
    const h = [];
    return console.log(_.tableData, _.originData), (V = _.tableData) == null || V.forEach((l) => {
      if (n(_.originData)) if (_.originData.findIndex((s) => s.id === l.id) > -1) {
        const s = _.originData.find((o) => o.id === l.id);
        u(l, s) ? h.push({ ...l, typeName: "无变更", color: "#909399" }) : h.push({ ...l, originVal: s, typeName: "修改", color: "#e6a23c" });
      } else h.push({ ...l, typeName: "新增", color: "green" });
      else h.push({ ...l, typeName: "新增", color: "green" });
    }), _.originData.forEach((l) => {
      h.findIndex((s) => s.id === l.id) < 0 && h.push({ ...l, typeName: "删除", color: "red" });
    }), h;
  });
  return (h, V) => {
    const l = k, s = b("common-table");
    return t(), e(s, { data: c.value, "return-source-data": "", showEmptySymbol: false, border: "" }, { default: a(() => [i(l, { label: "序号", type: "index", align: "center", width: "60" }), i(l, { prop: "typeName", label: "变更类型", type: "index", align: "center", width: "60" }, { default: a((o) => [w("span", { style: d(`color:${o.row.color}`) }, g(o.row.typeName), 5)]), _: 1 }), i(l, { prop: "plateType", "show-overflow-tooltip": true, align: "center", label: "板型" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.plateType, o.row.originVal.plateType) ? (t(), e(r(f), { key: 0, old: o.row.originVal.plateType, new: o.row.plateType }, null, 8, ["old", "new"])) : (t(), y("span", W, g(o.row.plateType), 1))], 4)]), _: 1 }), i(l, { prop: "unfoldedWidth", "show-overflow-tooltip": true, align: "center", label: "展宽(mm)" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.unfoldedWidth, o.row.originVal.unfoldedWidth) ? (t(), e(r(f), { key: 0, old: o.row.originVal.unfoldedWidth, new: o.row.unfoldedWidth }, null, 8, ["old", "new"])) : (t(), y("span", $, g(o.row.unfoldedWidth), 1))], 4)]), _: 1 }), i(l, { prop: "effectiveWidth", "show-overflow-tooltip": true, align: "center", label: "有效宽(mm)" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.effectiveWidth, o.row.originVal.effectiveWidth) ? (t(), e(r(f), { key: 0, old: o.row.originVal.effectiveWidth, new: o.row.effectiveWidth }, null, 8, ["old", "new"])) : (t(), y("span", v, g(o.row.effectiveWidth), 1))], 4)]), _: 1 }), i(l, { prop: "thickness", "show-overflow-tooltip": true, align: "center", label: "板厚(mm)" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.thickness, o.row.originVal.thickness) ? (t(), e(r(f), { key: 0, old: o.row.originVal.thickness, new: o.row.thickness }, null, 8, ["old", "new"])) : (t(), y("span", D, g(o.row.thickness), 1))], 4)]), _: 1 }), i(l, { prop: "coating", "show-overflow-tooltip": true, align: "center", label: "涂层" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.coating, o.row.originVal.coating) ? (t(), e(r(f), { key: 0, old: o.row.originVal.coating, new: o.row.coating }, null, 8, ["old", "new"])) : (t(), y("span", N, g(o.row.coating), 1))], 4)]), _: 1 }), i(l, { prop: "plating", "show-overflow-tooltip": true, align: "center", label: "镀层" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.plating, o.row.originVal.plating) ? (t(), e(r(f), { key: 0, old: o.row.originVal.plating, new: o.row.plating }, null, 8, ["old", "new"])) : (t(), y("span", S, g(o.row.plating), 1))], 4)]), _: 1 }), i(l, { prop: "yieldStrength", "show-overflow-tooltip": true, align: "center", label: "屈服强度" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.yieldStrength, o.row.originVal.yieldStrength) ? (t(), e(r(f), { key: 0, old: o.row.originVal.yieldStrength, new: o.row.yieldStrength }, null, 8, ["old", "new"])) : (t(), y("span", x, g(o.row.yieldStrength), 1))], 4)]), _: 1 }), i(l, { prop: "brand", "show-overflow-tooltip": true, align: "center", label: "品牌" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.brand, o.row.originVal.brand) ? (t(), e(r(f), { key: 0, old: o.row.originVal.brand, new: o.row.brand }, null, 8, ["old", "new"])) : (t(), y("span", T, g(o.row.brand), 1))], 4)]), _: 1 }), i(l, { prop: "colour", "show-overflow-tooltip": true, align: "center", label: "颜色" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.colour, o.row.originVal.colour) ? (t(), e(r(f), { key: 0, old: o.row.originVal.colour, new: o.row.colour }, null, 8, ["old", "new"])) : (t(), y("span", q, g(o.row.colour), 1))], 4)]), _: 1 }), i(l, { prop: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量(m)" }, { default: a((o) => [w("span", { style: d(`color:${r(n)(o.row.originVal) ? "" : o.row.color};`) }, [r(n)(o.row.originVal) && !r(u)(o.row.quantity, o.row.originVal.quantity) ? (t(), e(r(f), { key: 0, old: o.row.originVal.quantity, new: o.row.quantity }, null, 8, ["old", "new"])) : (t(), y("span", B, g(o.row.quantity), 1))], 4)]), _: 1 })]), _: 1 }, 8, ["data"]);
  };
} };
export {
  I as default
};
