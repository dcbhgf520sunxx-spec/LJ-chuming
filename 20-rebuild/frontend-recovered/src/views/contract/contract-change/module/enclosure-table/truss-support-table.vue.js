import { computed as k } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as l } from "vue";
import { createBlock as n } from "vue";
import { withCtx as a } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as w } from "vue";
import { normalizeStyle as u } from "vue";
import { toDisplayString as d } from "vue";
import { unref as e } from "vue";
import { createElementBlock as f } from "vue";
import { ElTableColumn as c } from "element-plus";
import { j as g } from "../../../../../modules/judgeSameValue-9683bdce.js";
import { i as t } from "../../../../../shared/runtime.js";
import { _ as s } from "../../../../../modules/index-61ce89a1.js";
const M = { key: 1 }, p = { key: 1 }, N = { key: 1 }, Q = { key: 1 }, $ = { key: 1 }, D = { key: 1 }, x = { key: 1 }, q = { key: 1 }, W = { key: 1 }, B = { key: 1 }, j = { __name: "truss-support-table", props: { tableData: { type: Array, default: () => [] }, originData: { type: Array, default: () => [] } }, setup(V) {
  const b = V, h = k(() => {
    var _;
    const m = [];
    return (_ = b.tableData) == null || _.forEach((o) => {
      if (t(b.originData)) if (b.originData.findIndex((y) => y.id === o.id) > -1) {
        const y = b.originData.find((r) => r.id === o.id);
        g(o, y) ? m.push({ ...o, typeName: "无变更", color: "#909399" }) : m.push({ ...o, originVal: y, typeName: "修改", color: "#e6a23c" });
      } else m.push({ ...o, typeName: "新增", color: "green" });
      else m.push({ ...o, typeName: "新增", color: "green" });
    }), b.originData.forEach((o) => {
      m.findIndex((y) => y.id === o.id) < 0 && m.push({ ...o, typeName: "删除", color: "red" });
    }), m;
  });
  return (m, _) => {
    const o = c, y = v("common-table");
    return l(), n(y, { data: h.value, "return-source-data": "", showEmptySymbol: false, border: "" }, { default: a(() => [i(o, { label: "序号", type: "index", align: "center", width: "60" }), i(o, { prop: "typeName", label: "变更类型", type: "index", align: "center", width: "60" }, { default: a((r) => [w("span", { style: u(`color:${r.row.color}`) }, d(r.row.typeName), 5)]), _: 1 }), i(o, { prop: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "板型" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.serialNumber, r.row.originVal.serialNumber) ? (l(), n(e(s), { key: 0, old: r.row.originVal.serialNumber, new: r.row.serialNumber }, null, 8, ["old", "new"])) : (l(), f("span", M, d(r.row.serialNumber), 1))], 4)]), _: 1 }), i(o, { prop: "basementMembrane", "show-overflow-tooltip": true, align: "center", label: "底膜(mm)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.basementMembrane, r.row.originVal.basementMembrane) ? (l(), n(e(s), { key: 0, old: r.row.originVal.basementMembrane, new: r.row.basementMembrane }, null, 8, ["old", "new"])) : (l(), f("span", p, d(r.row.basementMembrane), 1))], 4)]), _: 1 }), i(o, { prop: "effectiveWidth", "show-overflow-tooltip": true, align: "center", label: "有效宽度" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.effectiveWidth, r.row.originVal.effectiveWidth) ? (l(), n(e(s), { key: 0, old: r.row.originVal.effectiveWidth, new: r.row.effectiveWidth }, null, 8, ["old", "new"])) : (l(), f("span", N, d(r.row.effectiveWidth), 1))], 4)]), _: 1 }), i(o, { prop: "firstQuarter", "show-overflow-tooltip": true, align: "center", label: "上弦筋(φ)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.firstQuarter, r.row.originVal.firstQuarter) ? (l(), n(e(s), { key: 0, old: r.row.originVal.firstQuarter, new: r.row.firstQuarter }, null, 8, ["old", "new"])) : (l(), f("span", Q, d(r.row.firstQuarter), 1))], 4)]), _: 1 }), i(o, { prop: "lastQuarter", "show-overflow-tooltip": true, align: "center", label: "下弦筋(φ)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.lastQuarter, r.row.originVal.lastQuarter) ? (l(), n(e(s), { key: 0, old: r.row.originVal.lastQuarter, new: r.row.lastQuarter }, null, 8, ["old", "new"])) : (l(), f("span", $, d(r.row.lastQuarter), 1))], 4)]), _: 1 }), i(o, { prop: "webMember", "show-overflow-tooltip": true, align: "center", label: "腹杆筋(φ)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.webMember, r.row.originVal.webMember) ? (l(), n(e(s), { key: 0, old: r.row.originVal.webMember, new: r.row.webMember }, null, 8, ["old", "new"])) : (l(), f("span", D, d(r.row.webMember), 1))], 4)]), _: 1 }), i(o, { prop: "vertical", "show-overflow-tooltip": true, align: "center", label: "竖向筋(φ)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.vertical, r.row.originVal.vertical) ? (l(), n(e(s), { key: 0, old: r.row.originVal.vertical, new: r.row.vertical }, null, 8, ["old", "new"])) : (l(), f("span", x, d(r.row.vertical), 1))], 4)]), _: 1 }), i(o, { prop: "level", "show-overflow-tooltip": true, align: "center", label: "水平筋(φ)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.level, r.row.originVal.level) ? (l(), n(e(s), { key: 0, old: r.row.originVal.level, new: r.row.level }, null, 8, ["old", "new"])) : (l(), f("span", q, d(r.row.level), 1))], 4)]), _: 1 }), i(o, { prop: "weightMeter", "show-overflow-tooltip": true, align: "center", label: "米重(kg/m)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.weightMeter, r.row.originVal.weightMeter) ? (l(), n(e(s), { key: 0, old: r.row.originVal.weightMeter, new: r.row.weightMeter }, null, 8, ["old", "new"])) : (l(), f("span", W, d(r.row.weightMeter), 1))], 4)]), _: 1 }), i(o, { prop: "quantity", "show-overflow-tooltip": true, align: "center", label: "数量(m)" }, { default: a((r) => [w("span", { style: u(`color:${e(t)(r.row.originVal) ? "" : r.row.color};`) }, [e(t)(r.row.originVal) && !e(g)(r.row.quantity, r.row.originVal.quantity) ? (l(), n(e(s), { key: 0, old: r.row.originVal.quantity, new: r.row.quantity }, null, 8, ["old", "new"])) : (l(), f("span", B, d(r.row.quantity), 1))], 4)]), _: 1 })]), _: 1 }, 8, ["data"]);
  };
} };
export {
  j as default
};
