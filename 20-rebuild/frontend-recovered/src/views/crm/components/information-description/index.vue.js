import { openBlock as t } from "vue";
import { createBlock as d } from "vue";
import { withCtx as s } from "vue";
import { createElementBlock as o } from "vue";
import { Fragment as _ } from "vue";
import { renderList as D } from "vue";
import { createVNode as h } from "vue";
import { toDisplayString as n } from "vue";
import { unref as r } from "vue";
import { normalizeStyle as N } from "vue";
import { createElementVNode as y } from "vue";
import { createCommentVNode as S } from "vue";
import { ElDescriptionsItem as w } from "element-plus";
import { ElDescriptions as k } from "element-plus";
import { _ as b, g8 as x, p as C, c7 as E, au as j } from "../../../../shared/runtime.js";
const B = { key: 0 }, L = { key: 1 }, v = { key: 2 }, F = { key: 3 }, M = { key: 4 }, V = { key: 5 }, P = { __name: "index", props: { descriptionsList: { type: Array, default: () => [] }, formDetail: { type: Object, default: () => {
} } }, setup(u) {
  const p = x(["info_source"]), a = u;
  return (T, z) => {
    const i = w, f = k;
    return t(), d(f, { column: 3, border: "", size: "large" }, { default: s(() => [(t(true), o(_, null, D(a.descriptionsList, (e, g) => (t(), o(_, { key: g }, [h(i, { label: e.fieldName }, { default: s(() => {
      var c, l, m;
      return [e.argumentShowName === "informantDateTime" || e.argumentShowName === "bidExpirationDate" || e.argumentShowName === "bidOpeningDate" || e.argumentShowName === "tenderBondDeadline" || e.argumentShowName === "startDate" || e.argumentShowName === "endDate" || e.argumentShowName === "deadlineForAcceptanceTime" || e.argumentShowName === "followUpDate" || e.argumentShowName === "lastFollowUpDate" ? (t(), o("span", B, n(r(C)(a.formDetail[e.argumentShowName], "{y}-{m}-{d}") || "-"), 1)) : e.argumentShowName === "allDate" ? (t(), o("span", L, n(r(E)(a.formDetail.startDate, a.formDetail.endDate) || "-"), 1)) : e.argumentShowName === "regionList" ? (t(), o("span", v, n(a.formDetail.countryName + a.formDetail.provinceName + a.formDetail.cityName + a.formDetail.regionName || "-"), 1)) : e.argumentShowName === "infoSource" ? (t(), o("span", F, n((m = (l = (c = r(p)) == null ? void 0 : c.label) == null ? void 0 : l.info_source) == null ? void 0 : m[a.formDetail.infoSource]), 1)) : e.argumentShowName === "isProjectManagerCoordinate" ? (t(), o("span", M, n(r(j).VL[a.formDetail[e.argumentShowName]] || "-"), 1)) : (t(), o("span", V, n(a.formDetail[e.argumentShowName] || "-"), 1))];
    }), _: 2 }, 1032, ["label"]), e.argumentName === "isProjectManagerCoordinate" ? (t(), d(i, { key: 0, style: N({ display: e.isProjectManagerCoordinate ? "block" : "none" }), label: "项目经理名称" }, { default: s(() => [y("span", null, n(a.formDetail.projectManagerName || "-"), 1)]), _: 2 }, 1032, ["style"])) : S("", true)], 64))), 128))]), _: 1 });
  };
} }, O = b(P, [["__scopeId", "data-v-3824df84"]]);
export {
  O as default
};
