function tN(e, o) {
  if (dw(e, o)) {
    const n = new RegExp("(\\s|^)" + o + "(\\s|$)");
    e.className = e.className.replace(n, " ");
  }
}
const iN = { class: "rightPanel" }, aN = { class: "rightPanel-items" }, lN = { __name: "index", props: { clickNotClose: { default: false, type: Boolean }, buttonTop: { default: 250, type: Number } }, setup(e) {
  const o = Ht(), n = e, c = Z(), { theme: u } = ka("theme"), r = Ee({ get() {
    return o.getters.showSettings;
  }, set(b) {
    o.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["showSettings", b]]));
  } });
  Ce(r, (b) => {
    b && !n.clickNotClose && E(), b ? eN(document.body, "showRightPanel") : tN(document.body, "showRightPanel");
  }), El(() => {
    r.value && E();
  });
  function E() {
    window.addEventListener("click", y, { passive: false });
  }
  function y(b) {
    b.target.closest(".rightPanel") || (r.value = false, window.removeEventListener("click", this.closeSidebar));
  }
  return (b, V) => {
    const M = wV, g = ml, S = SV;
    return w(), Q("div", { ref_key: "rightPanel", ref: c, class: Zt([{ show: r.value }, "rightPanel-container"]) }, [V[1] || (V[1] = C("div", { class: "rightPanel-background" }, null, -1)), C("div", iN, [qe(C("div", { class: "handle-button", style: ri({ top: e.buttonTop + "px", "background-color": l(u) || "#1890ff" }), onClick: V[0] || (V[0] = (h) => r.value = !r.value) }, [r.value ? (w(), U(g, { key: 0 }, { default: p(() => [s(M)]), _: 1 })) : (w(), U(g, { key: 1 }, { default: p(() => [s(S)]), _: 1 }))], 4), [[ln, r.value]]), C("div", aN, [xt(b.$slots, "default", {}, void 0, true)])])], 2);
  };
} }, oN = ut(lN, [["__scopeId", "data-v-a569c7ce"]]);
const nN = { class: "drawer-container" }, sN = { class: "drawer-item" }, rN = { class: "drawer-item" }, uN = { class: "drawer-item" }, cN = { class: "drawer-item" }, dN = { __name: "index", setup(e) {
  const o = Ht(), n = Ee({ get() {
    return o.getters.fixedHeader;
  }, set(E) {
    o.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["fixedHeader", E]]));
  } }), c = Ee({ get() {
    return o.getters.tagsView;
  }, set(E) {
    o.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["tagsView", E]]));
  } }), u = Ee({ get() {
    return o.getters.showSidebarLogo;
  }, set(E) {
    o.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["showSidebarLogo", E]]));
  } }), r = Ee({ get() {
    return o.getters.switchBackgroundColor;
  }, set(E) {
    o.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["switchBackgroundColor", E]]));
  } });
  return (E, y) => {
    const b = vV;
    return w(), Q("div", nN, [C("div", null, [y[8] || (y[8] = C("h3", { class: "drawer-title" }, "页面风格设计", -1)), C("div", sN, [y[4] || (y[4] = C("span", null, "查看标签", -1)), s(b, { modelValue: c.value, "onUpdate:modelValue": y[0] || (y[0] = (V) => c.value = V), class: "drawer-switch" }, null, 8, ["modelValue"])]), C("div", rN, [y[5] || (y[5] = C("span", null, "固定头部", -1)), s(b, { modelValue: n.value, "onUpdate:modelValue": y[1] || (y[1] = (V) => n.value = V), class: "drawer-switch" }, null, 8, ["modelValue"])]), C("div", uN, [y[6] || (y[6] = C("span", null, "侧边栏 Logo", -1)), s(b, { modelValue: u.value, "onUpdate:modelValue": y[2] || (y[2] = (V) => u.value = V), class: "drawer-switch" }, null, 8, ["modelValue"])]), C("div", cN, [y[7] || (y[7] = C("span", null, "灰色背景", -1)), s(b, { modelValue: r.value, "onUpdate:modelValue": y[3] || (y[3] = (V) => r.value = V), class: "drawer-switch" }, null, 8, ["modelValue"])])])]);
  };
} }, mN = ut(dN, [["__scopeId", "data-v-da7cf828"]]);
const pN = { class: "comp-enterprise-info" }, hN = { class: "info-container" }, fN = { class: "item" }, gN = { class: "content" }, EN = { class: "item" }, yN = { class: "content" }, TN = { class: "item" }, _N = { class: "content" }, bN = { class: "bottom-content" }, VN = { class: "logo" }, wN = { class: "qr" }, SN = { __name: "index", setup(e) {
  const o = Z({});
  n();
  async function n() {
    try {
      const local = await d(() => import("./enterprise-information-1064963f.js"), []);
      o.value = await local.getCustomer();
    } catch {
      o.value = {name: _e.getters.user?.companyName || null, code: null, version: null, logo: null};
    }
  }
  async function c(u) {
    if (!u) return;
    try {
      await navigator.clipboard.writeText(u), ot.success("复制成功");
    } catch (r) {
      console.error("Failed to copy!", r);
    }
  }
  return (u, r) => {
    const E = RV, y = ml, b = Um;
    return w(), Q("div", pN, [C("div", hN, [C("div", fN, [r[1] || (r[1] = C("div", { class: "title" }, "名称", -1)), C("div", gN, K(o.value.name || "待确认"), 1)]), C("div", EN, [r[2] || (r[2] = C("div", { class: "title" }, "编码", -1)), C("div", yN, [Te(K(o.value.code || "待确认") + " ", 1), s(y, { style: { cursor: "pointer", color: "rgb(179, 179, 179)" }, onClick: r[0] || (r[0] = (V) => c(o.value.code)) }, { default: p(() => [s(E)]), _: 1 })])]), C("div", TN, [r[3] || (r[3] = C("div", { class: "title" }, "版本", -1)), C("div", _N, K(o.value.version || "待确认"), 1)])]), C("div", bN, [C("div", VN, [o.value.logo ? (w(), U(b, { key: 0, class: "logo-img", src: o.value.logo, alt: "logo", fit: "scale-down" }, null, 8, ["src"])) : H("", true)]), C("div", wN, [o.value.code ? (w(), U(w6, { key: 0, value: o.value.code, size: 135, margin: 2 }, null, 8, ["value"])) : H("", true)])])]);
  };
} }, vN = ut(SN, [["__scopeId", "data-v-376e3b96"]]);
function Ta({ emit: e, props: o, field: n = "modelValue", closeHook: c, showHook: u }) {
  const r = Z(false);
  return Ce(() => o[n], (y) => {
    r.value = y, y && typeof u == "function" && u();
  }), { visible: r, handleClose: () => {
    typeof c == "function" && c(), e(`update:${[n]}`, false);
  } };
}
const RN = { __name: "index", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(e, { emit: o }) {
  const n = o, c = e, { visible: u, handleClose: r } = Ta({ emit: n, props: c, field: "visible" });
  return (E, y) => {
    const b = S6, V = Ve("common-dialog");
    return w(), U(V, { title: "企业信息", class: "company-information-dialog", showClose: false, modelValue: l(u), "onUpdate:modelValue": y[0] || (y[0] = (M) => Gt(u) ? u.value = M : null), width: "380px", "before-close": l(r) }, { default: p(() => [s(vN), s(b, { type: "info", title: "企业编码及二维码仅供企业内部使用请勿泄露给其它企业/人员", "show-icon": "", closable: false })]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, MN = ut(RN, [["__scopeId", "data-v-228970f7"]]);
const AN = { class: "avatar-wrapper" }, NN = { __name: "index", props: { avatarStyle: { type: Object, default: () => ({ width: "40px", height: "40px", "border-radius": "50%" }) }, placement: { type: String, default: "left-end" }, showLayout: { type: Boolean, default: true } }, setup(e) {
  const o = e, n = Ht(), c = jn(), u = eu(), r = Z(false), { user: E } = ka("user"), y = Ee({ get() {
    return n.getters.showSettings;
  }, set(V) {
    n.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["showSettings", V]]));
  } });
  async function b() {
    try {
      await n.dispatch("user/logout"), u.path === "/" || u.path.indexOf("/login?") > -1 ? c.go(0) : c.push("/login");
    } catch (V) {
      console.log(V);
    } finally {
      setTimeout(() => {
        location.reload();
      }, 300);
    }
  }
  return (V, M) => {
    const g = v6, S = ml, h = jt, T = MV, _ = Ve("router-link"), f = AV, m = NV;
    return w(), Q("div", { class: "avatar-container", style: ri({ width: `${+o.avatarStyle.width.split("px")[0] + 20}px`, height: o.avatarStyle.height }) }, [s(m, { trigger: "click" }, { dropdown: p(() => [s(f, { class: "user-dropdown" }, { default: p(() => [s(_, { class: "inlineBlock", to: "/login" }, { default: p(() => [s(T, null, { default: p(() => M[3] || (M[3] = [Te(" 首页 ")])), _: 1, __: [3] })]), _: 1 }), s(_, { class: "inlineBlock", to: "/personal/center" }, { default: p(() => [s(T, null, { default: p(() => M[4] || (M[4] = [Te(" 个人中心 ")])), _: 1, __: [4] })]), _: 1 }), C("span", { style: { display: "block" }, onClick: M[0] || (M[0] = (R) => r.value = true) }, [s(T, null, { default: p(() => M[5] || (M[5] = [Te(" 企业信息 ")])), _: 1, __: [5] })]), e.showLayout ? (w(), Q("span", { key: 0, style: { display: "block" }, onClick: M[1] || (M[1] = (R) => y.value = true) }, [s(T, null, { default: p(() => M[6] || (M[6] = [Te(" 布局设置 ")])), _: 1, __: [6] })])) : H("", true), s(T, { divided: "", onClick: b }, { default: p(() => M[7] || (M[7] = [Te("退出登录")])), _: 1, __: [7] })]), _: 1 })]), default: p(() => [C("span", null, [s(h, { class: "item", effect: "dark", content: `当前用户：${l(E).name}`, placement: e.placement }, { default: p(() => [C("div", AN, [C("img", { class: "user-avatar", src: $A, style: ri(o.avatarStyle) }, null, 4), s(S, null, { default: p(() => [s(g)]), _: 1 })])]), _: 1 }, 8, ["content", "placement"])])]), _: 1 }), s(oN, null, { default: p(() => [s(mN)]), _: 1 }), s(MN, { visible: r.value, "onUpdate:visible": M[2] || (M[2] = (R) => r.value = R) }, null, 8, ["visible"])], 4);
  };
} }, LN = ut(NN, [["__scopeId", "data-v-677d6198"]]), Er = (e) => {
  const o = Ht(), n = Ee(() => o.state.project.loaded);
  if (n.value || o.dispatch("project/fetchUserProjects"), e) {
    const c = Ce(n, (u) => {
      u && setTimeout(() => {
        e(), c();
      }, 0);
    }, { immediate: true });
  }
  return { loaded: n, projectsAll: Ee(() => {
    var c;
    return ((c = o.state.project.userProjectsMap) == null ? void 0 : c[Ot]) || [];
  }), projects: Ee(() => o.state.project.userProjects), processProjects: Ee(() => o.state.project.userProcessProjects), projectsCascade: Ee(() => o.state.project.userProjectsCascade), businessTypeProjectMap: Ee(() => o.state.project.userBusinessTypeProjectMap), userBusinessTypeProjectsCascadeMap: Ee(() => o.state.project.userBusinessTypeProjectsCascadeMap), userProjectsMap: Ee(() => o.state.project.userProjectsMap) };
};
function Qi(e, o) {
  if (!e || arguments.length === 0) return null;
  const n = o || "{y}-{m}-{d} {h}:{i}:{s}";
  let c;
  typeof e == "object" ? c = e : (typeof e == "string" && /^[0-9]+$/.test(e) && (e = parseInt(e)), typeof e == "number" && e.toString().length === 10 && (e = e * 1e3), c = new Date(e));
  const u = { y: c.getFullYear(), m: c.getMonth() + 1, d: c.getDate(), h: c.getHours(), i: c.getMinutes(), s: c.getSeconds(), a: c.getDay() };
  return n.replace(/{([ymdhisa])+}/g, (E, y) => {
    const b = u[y];
    return y === "a" ? ["日", "一", "二", "三", "四", "五", "六"][b] : b.toString().padStart(2, "0");
  });
}
function sr(e, o) {
  e = /* @__PURE__ */ new Date(+e), o = /* @__PURE__ */ new Date(+o), e = `${e.getFullYear()}-${Lu(e.getMonth() + 1)}-${Lu(e.getDate())}`, o = `${o.getFullYear()}-${Lu(o.getMonth() + 1)}-${Lu(o.getDate())}`, e = Date.parse(e), o = Date.parse(o);
  let c = o - e;
  return c = Math.abs(c) + 864e5, Math.floor(c / 864e5);
}
function yr(e) {
  const o = new Date((e - 1) * 24 * 36e5 + 1);
  return o.setYear(o.getFullYear() - 70), o.getTime();
}
const IN = { class: "cascader-container" }, CN = { class: "project-cascader-container" }, PN = { style: { "font-size": "13px", "margin-left": "15px", "margin-bottom": "5px", color: "#333" } }, ON = { __name: "index", props: { modelValue: { type: [Array, Number] }, checkStrictly: { type: Boolean, default: false }, expandTrigger: { type: String, default: "hover" }, emitPath: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: true }, showAllLevels: { type: Boolean, default: false }, placeholder: { type: String, default: "可选择项目" } }, setup(e) {
  const o = Ht();
  jn(), o.dispatch("project/fetchProjectTree");
  const n = e, { routeProjectType: c, routeFilterHasEnclosure: u, currentProjectType: r, globalProjectId: E, globalProject: y, navbarShowAll: b, routeBusinessType: V, projectTypeEnumArr: M } = ka(["routeProjectType", "routeFilterHasEnclosure", "currentProjectType", "globalProjectId", "globalProject", "navbarShowAll", "routeBusinessType", "projectTypeEnumArr"]), g = Z(), S = Z(r.value), h = Z(false);
  let T = false;
  const _ = Ee(() => A(c.value)), { projectsCascade: f, processProjects: m, projects: R, businessTypeProjectMap: v, userBusinessTypeProjectsCascadeMap: N } = Er(), P = Ee(() => {
    var j;
    const q = Ot || S.value;
    let ae = [];
    if (b.value) {
      if (ae = V.value ? N.value[V.value + "_" + q] : f.value, u.value) for (let le = 0; le < ae.length; le++) for (let oe = 0; oe < ae[le].children.length; oe++) (j = ae[le].children[oe].children) != null && j.length && (ae[le].children[oe].children = ae[le].children[oe].children.filter((ye) => ye.hasEnclosure));
    } else ae = V.value ? v.value[V.value + "_" + q] : m.value, u.value && (ae = ae.filter((le) => le.hasEnclosure));
    return ae;
  });
  function L(q, ae) {
    var j, le, oe, ye, ce, se;
    if (((le = (j = q == null ? void 0 : q.data) == null ? void 0 : j.label) == null ? void 0 : le.indexOf(ae)) > -1 || ((ye = (oe = q == null ? void 0 : q.data) == null ? void 0 : oe.name) == null ? void 0 : ye.indexOf(ae)) > -1 || ((se = (ce = q == null ? void 0 : q.data) == null ? void 0 : ce.shortName) == null ? void 0 : se.indexOf(ae)) > -1) return true;
  }
  const O = Ee(() => ({ value: "id", label: "label", children: "children", checkStrictly: n.checkStrictly, expandTrigger: n.expandTrigger, emitPath: n.emitPath, multiple: n.multiple })), x = Ee(() => {
    const q = [];
    return c.value !== Ot && (Object.keys($e.VL).forEach((ae) => {
      ae & c.value || q.push(Number(ae));
    }), q.push(Ot)), q;
  });
  Ce(b, (q) => {
    const ae = S.value || Ot;
    let j = false;
    q ? j = V.value ? N.value[V.value + "_" + ae].some((le) => le.id === g.value) : R.value.some((le) => le.id === g.value) : j = V.value ? v.value[V.value + "_" + ae].some((le) => le.id === g.value) : m.value.some((le) => le.id === g.value), j || Y(void 0);
  }), Ce(E, (q) => {
    var ae;
    q && (V.value && ((ae = y.value) == null ? void 0 : ae.businessType) === V.value || !V.value) ? T || (g.value = q) : Y(void 0);
  }, { immediate: true }), Ce(c, (q, ae) => {
    if (q && q !== Ot && (S.value === Ot || !(q & S.value) && S.value !== Ot)) {
      const j = lw(c.value);
      S.value = j.length && j.length <= 1 ? q : q & r ? r : j[0], I(S.value);
    }
  });
  async function I(q) {
    try {
      await o.dispatch("project/changeProjectType", q);
    } catch (ae) {
      console.log("切换项目", ae);
    }
  }
  async function Y(q) {
    T = true;
    try {
      await o.dispatch("project/setProjectId", q);
    } catch (ae) {
      console.log(ae);
    } finally {
      T = false;
    }
  }
  function ee() {
    h.value = true;
    try {
      o.dispatch("project/fetchUserProjects");
    } catch (q) {
      console.log("刷新项目", q);
    } finally {
      h.value = false;
    }
  }
  function B() {
    o.commit("project/SET_NAVBAR_SHOW_ALL", !b.value);
  }
  return (q, ae) => {
    const j = Ve("common-select"), le = Ns, oe = LV, ye = ml, ce = hr, se = jt, he = wi, be = _t("parse-time");
    return qe((w(), Q("div", IN, [s(j, { modelValue: S.value, "onUpdate:modelValue": ae[0] || (ae[0] = (me) => S.value = me), "all-val": l(Ot), "disabled-val": x.value, options: l(M), class: "project-type-select", placeholder: "项目类型", "show-option-all": "", size: "default", type: "enumSL", onChange: I }, null, 8, ["modelValue", "all-val", "disabled-val", "options"]), C("span", CN, [s(le, { modelValue: g.value, "onUpdate:modelValue": ae[1] || (ae[1] = (me) => g.value = me), clearable: n.clearable, "filter-method": L, filterable: n.filterable, options: P.value, placeholder: n.placeholder, props: O.value, "show-all-levels": n.showAllLevels, class: "project-cascader", style: { width: "100%" }, onChange: Y }, null, 8, ["modelValue", "clearable", "filterable", "options", "placeholder", "props", "show-all-levels"]), C("span", { style: ri({ color: l(b) ? "#17db9b" : "#dcdfe6" }), class: "all-tip pointer", onClick: B }, " All ", 4)]), s(se, { class: "item", content: "刷新项目列表", effect: "dark", placement: "right" }, { default: p(() => [h.value ? (w(), U(ye, { key: 1 }, { default: p(() => [s(ce)]), _: 1 })) : (w(), U(ye, { key: 0, style: { cursor: "pointer" }, onClick: ee }, { default: p(() => [s(oe)]), _: 1 }))]), _: 1 }), C("div", PN, [!l(V) || l(y) && l(y).businessType === l(V) ? (w(), Q(Qe, { key: 0 }, [l(y) && l(y).endDate ? (w(), U(he, { key: 0, type: "info", effect: "plain", style: { "margin-top": "5px" } }, { default: p(() => [ae[2] || (ae[2] = Te(" 完成日期: ")), qe(C("span", null, null, 512), [[be, { val: l(y).endDate, fmt: "{y}-{m}-{d}" }]]), Te(" | 工期: " + K(l(sr)(l(y).startDate, l(y).endDate)) + "天 ", 1)]), _: 1, __: [2] })) : H("", true)], 64)) : H("", true), l(y) && l(y).businessType || l(V) ? (w(), U(he, { key: 1, effect: "plain", style: { "margin-top": "5px", "margin-left": "5px" }, type: "info" }, { default: p(() => {
      var me;
      return [Te(K((me = l(y)) != null && me.businessType ? l(xi).VL[l(y).businessType] : l(xi).VL[l(V)]), 1)];
    }), _: 1 })) : H("", true), !l(V) || l(y) && l(y).businessType === l(V) ? (w(), Q(Qe, { key: 2 }, [l(y) && l(y).mode ? (w(), U(he, { key: 0, type: "info", effect: "plain", style: { "margin-top": "5px", "margin-left": "5px" } }, { default: p(() => [Te(K("项目模式:" + l(ko).VL[l(y).mode]), 1)]), _: 1 })) : H("", true)], 64)) : H("", true)])], 512)), [[ln, _.value]]);
  };
} }, kN = ut(ON, [["__scopeId", "data-v-bdf9835e"]]);
const DN = { name: "SvgIcon", props: { iconClass: { type: String }, className: { type: String } }, computed: { iconName() {
  return `#icon-${this.iconClass}`;
}, svgClass() {
  return this.className ? "svg-icon " + this.className : "svg-icon";
} } }, xN = ["xlink:href"];
function UN(e, o, n, c, u, r) {
  return w(), Q("svg", { class: Zt(r.svgClass), "aria-hidden": "true" }, [C("use", { "xlink:href": r.iconName }, null, 8, xN)], 2);
}
const _o = ut(DN, [["render", UN], ["__scopeId", "data-v-c93c1747"]]), YN = { user: 1, contract: 1, plan: 1, wms: 1, config: 1, project: 1, scm: 1, common: 1, cutting: 1 };
function lot(e, o) {
  if (e) {
    var n = [];
    return Object.keys(o).forEach((c) => {
      let u = o[c];
      typeof u > "u" && (u = ""), n.push([c, encodeURIComponent(u)].join("="));
    }), `${e}?${n.join("&")}`;
  }
}
function Vs(e = 500) {
  return new Promise((o) => {
    setTimeout(() => {
      o();
    }, e);
  });
}
function im(e, o) {
  if (e) return WN(e, o) ? e : `${o}${e}`;
}
function Nc(e, o, n) {
  let c;
  return function() {
    const u = this, r = arguments;
    if (c && clearTimeout(c), n) {
      var E = !c;
      c = setTimeout(() => {
        c = null;
      }, o), E && e.apply(u, r);
    } else c = setTimeout(function() {
      e.apply(u, r);
    }, o);
  };
}
function oot(e, o) {
  for (const [n, c] of o) if (e[n] !== e[c]) return true;
  return false;
}
function not() {
  const e = URL.createObjectURL(new Blob()), o = e.toString();
  return URL.revokeObjectURL(e), o.substring(o.lastIndexOf("/") + 1);
}
function am(e) {
  return /^(https?:|mailto:|tel:)/.test(e);
}
function KN(e) {
  return /^(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:/~\+#]*[\w\-\@?^=%&amp;/~\+#])?/.test(e);
}
function mw(e) {
  return /^(http|ftp|https):\/\/([\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:/~\+#]*[\w\-\@?^=%&amp;/~\+#])?)|(localhost:[0-9]+[\w\-\@?^=%&amp;/~\+#]?)/.test(e);
}
function WN(e, o) {
  return new RegExp("^" + o).test(e);
}
const jN = { fileUploadApi: yn() + "/api/common/attachment", fileUploadCompanyLogoApi: yn() + "/api/config/company/logo", baseApi: { contract: "/api/", plan: "/api/plan/", user: "/api/", wms: "/api/wms/", wms_v2: "/api/v2/wms/", common: "/api/common/", config: "/api/config/", project: "/api/project/", mes: "/api/mes/building/", enclosure: "/api/mes/enclosure/", system: "/api/", cost: "/api/", scm: "/api/scm/", scm_V2: "api/v2/scm/", bridge: "/api/mes/bridge/", crm: "/api/crm/" } }, FN = { SET_BASE_API: (e, { baseUrl: o, apiVersion: n }) => {
  e.baseApi = { user: `/api/user/v${n.user}`, contract: `/api/contract/v${n.contract}`, project: `/api/project/v${n.common}`, wms: `/api/wms/v${n.wms}`, scm: `/api/wms/v${n.scm}`, common: `/api/common/v${n.common}` };
} }, zN = { setAPI({ commit: e, state: o }) {
  return new Promise((n, c) => {
    const u = yn();
    u || KN(u) ? (e("SET_BASE_API", { baseUrl: yn(), apiVersion: YN }), n()) : c();
  });
} }, BN = { namespaced: true, state: jN, mutations: FN, actions: zN }, HN = Object.freeze(Object.defineProperty({ __proto__: null, default: BN }, Symbol.toStringTag, { value: "Module" })), qN = { sidebar: { opened: ci.get("sidebarStatus") ? !!+ci.get("sidebarStatus") : true, withoutAnimation: false }, device: "desktop" }, GN = { TOGGLE_SIDEBAR: (e) => {
  e.sidebar.opened = !e.sidebar.opened, e.sidebar.withoutAnimation = false, e.sidebar.opened ? ci.set("sidebarStatus", 1) : ci.set("sidebarStatus", 0);
}, CLOSE_SIDEBAR: (e, o) => {
  ci.set("sidebarStatus", 0), e.sidebar.opened = false, e.sidebar.withoutAnimation = o;
}, TOGGLE_DEVICE: (e, o) => {
  e.device = o;
}, SET_SIZE: (e, o) => {
  e.size = o, ci.set("size", o);
} }, QN = { toggleSideBar({ commit: e }) {
  e("TOGGLE_SIDEBAR");
}, closeSideBar({ commit: e }, { withoutAnimation: o }) {
  e("CLOSE_SIDEBAR", o);
}, toggleDevice({ commit: e }, o) {
  e("TOGGLE_DEVICE", o);
}, setSize({ commit: e }, o) {
  e("SET_SIZE", o);
} }, ZN = { namespaced: true, state: qN, mutations: GN, actions: QN }, JN = Object.freeze(Object.defineProperty({ __proto__: null, default: ZN }, Symbol.toStringTag, { value: "Module" }));
function XN(e) {
  return W({ url: "api/user/all/simple", method: "get", params: e, cancelKey: false });
}
function $N() {
  return W({ url: "api/config/project/public", method: "get", cancelKey: false });
}
function e5() {
  return W({ url: "/api/config/watermarkConfig/get/public", method: "get", cancelKey: false });
}
function t5() {
  return W({ url: "/api/regionalCascade", method: "get" });
}
function i5(e = true) {
  return W({ module: "user", url: "dept/all/simple", method: "get", params: { hasRoot: true } });
}
function sot(e) {
  return W({ module: "user", url: "user/dept", method: "get", params: e });
}
function pw() {
  return W({ module: "user", method: "get", url: "user/tree", cancelKey: false });
}
function a5() {
  return W({ module: "scm", url: "supplier/all/brief", method: "get" });
}
function rot(e) {
  return W({ url: "/api/project/receiving/orderSupplier/list", method: "get", params: e });
}
function l5(e) {
  return W({ url: "/api/v2/scm/purchase-order/supplier/brief", method: "get", params: e });
}
function Lc({ id: e }) {
  return W({ module: "common", url: `attachment/download/${e}`, method: "get", timeout: 6e6, responseType: "blob" });
}
function uot(e) {
  return W({ url: "/api/plan/project/getProjectList", method: "get", params: e });
}
function cot(e) {
  return W({ url: "/api/plan/project/getProjectSummaryInfo", method: "get", params: e });
}
function dot(e) {
  return W({ module: "enclosure", url: "scheduling/v2/tree", method: "get", params: e });
}
function o5(e) {
  return W({ module: "wms_v2", url: "config/record/getCanCheck", method: "get", cancelKey: false, params: e });
}
function n5(e) {
  return W({ module: "wms_v2", url: "config/record/getSubmitAndReview", method: "get", params: e });
}
function s5(e) {
  return W({ module: "wms_v2", url: "config/record/getRejectedCanCheckCount", method: "get", params: e });
}
function mot(e) {
  return W({ url: "/api/config/getBimModelConfigConvertRestrict", method: "get", params: e });
}
function pot(e) {
  return W({ module: "project", url: "install-plan/getInstallSupplier/list", method: "get", params: e });
}
function r5() {
  return W({ url: "/api/regionalCascadeNew", method: "get" });
}
function u5(e) {
  return W({ module: "scm_V2", url: "apply-purchase", method: "get", params: e });
}
function c5(e) {
  return W({ module: "scm_V2", url: `apply-purchase/${e}`, method: "get" });
}
function hot(e) {
  return W({ module: "scm", url: `apply-purchase/schedule/${e}`, method: "get" });
}
function fot({ id: e }) {
  return W({ module: "scm", url: `apply-purchase/excel/${e}`, method: "get", responseType: "blob" });
}
function d5(e) {
  return W({ module: "scm_V2", url: "apply-purchase/saveCheck", method: "post", data: e });
}
