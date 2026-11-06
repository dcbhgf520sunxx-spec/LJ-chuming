const llt = { __name: "index", props: { apiKey: { type: [Array, String], default: void 0 }, currentKey: { type: String, default: void 0 }, beforePrint: { type: Function, default: void 0 }, size: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, params: { type: null, default: void 0 }, btnType: { type: String, default: "warning" } }, emits: ["update:currentKey", "change", "success", "download-success", "print-success"], setup(e, { expose: o, emit: n }) {
  const c = n, u = e, r = Z({}), E = Z(void 0), y = Z(void 0), b = Z(false), V = Z(false), { user: M } = ka("user"), g = Ee(() => M.value && M.value.id), S = Ee(() => {
    let L = "";
    if (A(u.apiKey)) if (u.apiKey instanceof Array) if (u.apiKey.length === 1) L = u.apiKey[0];
    else {
      L = u.apiKey;
      const O = Tn(L.map((x) => lc[x] || x));
      return O.length > 1 ? O : O[0];
    }
    else L = u.apiKey;
    return lc[L] || L;
  }), h = Ee(() => S.value instanceof Array), T = Ee(() => {
    if (A(r.value) && A(r.value.type)) {
      const L = r.value.type;
      if (u.apiKey instanceof Array) {
        for (const O of u.apiKey) if (O === L || lc[O] === L) return O;
      } else return u.apiKey;
    }
  });
  Ce(() => u.apiKey, (L) => {
    let O = "";
    A(L) && (O = L instanceof Array ? L[0] : L), y.value = m(O);
  }, { immediate: true }), Ce(() => T.value, (L) => {
    _(L);
  }), El(() => {
    V.value = true;
  });
  function _(L) {
    c("update:currentKey", L), c("change", L);
  }
  function f(L) {
    A(L) ? r.value = JSON.parse(typeof L == "object" ? JSON.stringify(L) : L) : r.value = "";
  }
  function m(L) {
    let O = "";
    return A(g.value) && A(L) && (O = (ci.get(`printTable_${g.value}`) || {})[L]), O;
  }
  function R(L, O) {
    if (A(g.value) && A(L) && A(O)) {
      const x = ci.get(`printTable_${g.value}`) || {};
      x[L] = O, ci.set(`printTable_${g.value}`, x);
    }
  }
  async function v() {
    if (typeof u.beforePrint != "function" || u.beforePrint() !== false) {
      R(T.value, E.value);
      const L = Dn.service({ lock: true, text: "准备导出", spinner: "el-icon-loading", fullscreen: true });
      try {
        let O = u.params;
        u.params instanceof Array || (O = [u.params]);
        for (const x of O) {
          const I = x;
          L.text = `正在加载数据：${r.value.name}`;
          const { header: Y, footer: ee, table: B, qrCode: q } = await P(x) || {};
          if (L.text = `正在导出：${r.value.name}`, await rPe({ header: Y, footer: ee, table: B, qrCode: q, config: r.value })) c("success"), c("download-success", I);
          else throw new Error("导出失败");
        }
      } catch (O) {
        ot.error(`${O}`), console.log("导出", O);
      } finally {
        L.text = "导出结束", L.close();
      }
    }
  }
  async function N(L) {
    if (typeof u.beforePrint != "function" || u.beforePrint() !== false) {
      R(T.value, E.value);
      const O = Dn.service({ lock: true, text: "准备打印", spinner: "el-icon-loading", fullscreen: true });
      try {
        let x = u.params;
        u.params instanceof Array || (x = [u.params]), L === Kl.PREVIEW.V && (x = [x[0]]);
        for (const I of x) {
          const Y = I;
          O.setText(`正在加载数据：${r.value.name}`);
          const { header: ee, footer: B, table: q, qrCode: ae } = await P(I) || {};
          O.setText(`正在打印：${r.value.name}`), console.log(r);
          const j = await i5e({ printMode: L, header: ee, footer: B, table: q, qrCode: ae, config: r.value });
          if (typeof j == "object") {
            const { type: le, message: oe } = j;
            return ot({ type: le, message: oe });
          }
          if (j) (L !== Kl.PREVIEW.V || L === Kl.PREVIEW.V && j === "printed") && (c("success"), c("print-success", Y));
          else throw new Error("打印失败");
        }
      } catch (x) {
        ot.error(`${x}`), console.log("打印", x);
      } finally {
        O.text = "打印结束", O.close();
      }
    }
  }
  async function P(L) {
    const O = T.value, x = r.value.type;
    if (O) try {
      const I = await WNe[O](L) || {};
      return console.log(x, "tableKey"), tV[x] ? await tV[x](I) : I;
    } catch (I) {
      throw console.error(I), new Error("加载打印数据失败");
    }
  }
  return o({ templateId: E }), (L, O) => {
    const x = Ve("common-button");
    return w(), Q("span", null, [s(l(PV), { class: "button-group" }, { default: p(() => [s(l(xo), { size: u.size, type: u.btnType, class: "input-button", plain: "" }, { default: p(() => [V.value ? (w(), Q(Qe, { key: 0 }, [h.value ? (w(), U(l(alt), { key: 0, value: E.value, "onUpdate:value": O[0] || (O[0] = (I) => E.value = I), "cache-template-id": y.value, size: u.size, "table-types": S.value, default: "", filterable: "", initial: "", onChange: f, onOnload: O[1] || (O[1] = (I) => b.value = true) }, null, 8, ["value", "cache-template-id", "size", "table-types"])) : (w(), U(l(ilt), { key: 1, value: E.value, "onUpdate:value": O[2] || (O[2] = (I) => E.value = I), "cache-template-id": y.value, size: u.size, "table-type": S.value, default: "", filterable: "", onChange: f, onOnload: O[3] || (O[3] = (I) => b.value = true) }, null, 8, ["value", "cache-template-id", "size", "table-type"]))], 64)) : H("", true)]), _: 1 }, 8, ["size", "type"]), s(x, { disabled: !b.value || u.disabled, size: u.size, type: u.btnType, icon: "el-icon-view", plain: "", onClick: O[4] || (O[4] = (I) => N(l(Kl).PREVIEW.V)) }, null, 8, ["disabled", "size", "type"]), s(x, { disabled: !b.value || u.disabled, size: u.size, type: u.btnType, icon: "el-icon-printer", plain: "", onClick: O[5] || (O[5] = (I) => N(l(Kl).QUEUE.V)) }, null, 8, ["disabled", "size", "type"]), s(x, { disabled: !b.value || u.disabled, size: u.size, type: u.btnType, icon: "el-icon-document-copy", plain: "", onClick: O[6] || (O[6] = (I) => N(l(Kl).CUSTOM_QUEUE.V)) }, null, 8, ["disabled", "size", "type"]), s(x, { disabled: !b.value || u.disabled, size: u.size, type: u.btnType, icon: "el-icon-download", plain: "", onClick: v }, null, 8, ["disabled", "size", "type"])]), _: 1 })]);
  };
} }, olt = ut(llt, [["__scopeId", "data-v-c676a9fd"]]);
const nlt = { class: "project-cascader-container" }, slt = { __name: "project-cascader", props: { modelValue: { type: [Array, Number] }, projectType: { type: Number, default: Ot }, showChildren: { type: Boolean, default: true }, checkStrictly: { type: Boolean, default: false }, expandTrigger: { type: String, default: "hover" }, collapseTags: { type: Boolean, default: false }, emitPath: { type: Boolean, default: false }, filterable: { type: Boolean, default: true }, multiple: { type: Boolean, default: false }, clearable: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, showAllLevels: { type: Boolean, default: false }, placeholder: { type: String, default: "可选择项目" } }, emits: ["update:modelValue", "change"], setup(e, { emit: o }) {
  const n = o, c = jn(), u = e, r = Z(), E = Z(false), y = Ee(() => ({ value: "id", label: "label", children: "children", checkStrictly: u.checkStrictly, expandTrigger: u.expandTrigger, emitPath: u.emitPath, multiple: u.multiple }));
  Ce(() => u.modelValue, (h) => {
    h instanceof Array ? r.value = [...h] : r.value = h, S(h);
  }, { immediate: true });
  const { projectsCascade: b, processProjects: V, projects: M } = Er(), g = Ee(() => {
    if (E.value) return b.value.forEach((T) => {
      T.children.length > 0 && T.children.forEach((_) => {
        _.children.length > 0 && (c.currentRoute.value.meta.moduleId === 9578 ? _.children = _.children.filter((f) => f.lumpSumSystemType === 8 || f.lumpSumSystemType === 16 || f.lumpSumSystemType === 1) : c.currentRoute.value.meta.moduleId === 3 ? _.children = _.children.filter((f) => f) : c.currentRoute.value.meta.moduleId === 2 ? _.children = _.children.filter((f) => f.lumpSumSystemType === 16 || f.lumpSumSystemType === 8 || f.lumpSumSystemType === 1) : c.currentRoute.value.meta.moduleId === 6 ? _.children = _.children.filter((f) => f.lumpSumSystemType === 2 || f.lumpSumSystemType === 8 || f.lumpSumSystemType === 16 || f.lumpSumSystemType === 1) : _.children = _.children.filter((f) => f));
      });
    }), b.value.map((T) => ({ ...T, children: T.children.map((_) => ({ ..._, children: _.children.filter((f) => u.showChildren ? true : !f.pid) })) }));
    let h = [];
    return c.currentRoute.value.meta.moduleId === 9578 ? h = V.value.filter((T) => T.lumpSumSystemType === 8 || T.lumpSumSystemType === 16 || T.lumpSumSystemType === 1) : c.currentRoute.value.meta.moduleId === 3 ? h = V.value.filter((T) => T) : c.currentRoute.value.meta.moduleId === 2 ? h = V.value.filter((T) => T.lumpSumSystemType === 16 || T.lumpSumSystemType === 8 || T.lumpSumSystemType === 1) : c.currentRoute.value.meta.moduleId === 6 ? h = V.value.filter((T) => T.lumpSumSystemType === 2 || T.lumpSumSystemType === 8 || T.lumpSumSystemType === 16 || T.lumpSumSystemType === 1) : h = V.value.filter((T) => T), h.filter((T) => u.showChildren ? true : !T.pid);
  });
  Ce(E, (h) => {
    let T = r.value;
    if (Array.isArray(r.value)) h ? T = M.value.map((_) => _.id).filter((_) => r.value.includes(_)) : T = V.value.map((_) => _.id).filter((_) => r.value.includes(_));
    else {
      let _ = false;
      h ? _ = M.value.some((f) => f.id === r.value) : _ = V.value.some((f) => f.id === r.value), _ || (T = void 0);
    }
    S(T);
  }, { immediate: true });
  function S(h) {
    const T = !el(h, u.modelValue), _ = Ae(h) && Ae(u.modelValue);
    return T && !_ ? (n("update:modelValue", h), n("change", h), true) : false;
  }
  return (h, T) => {
    const _ = Ns;
    return w(), Q("span", nlt, [s(_, { modelValue: r.value, "onUpdate:modelValue": T[0] || (T[0] = (f) => r.value = f), clearable: u.clearable, "collapse-tags": e.collapseTags, disabled: u.disabled, filterable: u.filterable, options: g.value, placeholder: u.placeholder, props: y.value, "show-all-levels": u.showAllLevels, class: "project-cascader", style: { width: "100%" }, onChange: S }, null, 8, ["modelValue", "clearable", "collapse-tags", "disabled", "filterable", "options", "placeholder", "props", "show-all-levels"]), C("span", { style: ri({ color: E.value ? "cornflowerblue" : "#c1c2c5" }), class: "all-tip", onClick: T[1] || (T[1] = (f) => E.value = !E.value) }, " All ", 4)]);
  };
} }, rlt = ut(slt, [["__scopeId", "data-v-27dfd75b"]]), ult = { __name: "component-radio-button", props: { modelValue: [Number, String, Boolean, void 0], size: { type: String, default: "default" }, options: { type: [Object, Array, Number], required: true }, default: { type: Boolean, default: false }, disabled: { type: Boolean, default: false }, disabledVal: { type: Array, default: () => [] }, unshowVal: { type: Array, default: () => [] }, type: { type: String, default: "other" }, showOptionAll: { type: Boolean, default: false } }, emits: ["change", "update:modelValue"], setup(e, { emit: o }) {
  const n = o, c = e, { productMenu: u } = ka("productMenu"), r = Ee(() => {
    const M = [];
    for (const g in li.ENUM) {
      const S = li.KV[g];
      S & u.value || M.push(S);
    }
    return M;
  }), E = Ee(() => Tn([...c.unshowVal, ...r.value])), y = Ee(() => {
    const M = [];
    for (const g in c.options) {
      const S = c.options[g].V;
      E.value.indexOf(S) === -1 && M.push(S);
    }
    return !M.length || M.length <= 1;
  }), b = Z();
  Ce(() => c.modelValue, (M) => {
    b.value = M;
  }, { immediate: true });
  function V(M) {
    let g = M;
    Ae(g) && (g = void 0);
    const S = !el(g, c.modelValue), h = Ae(g) && Ae(c.modelValue);
    S && !h && (n("update:modelValue", g), n("change", g));
  }
  return (M, g) => {
    const S = Ve("common-radio-button");
    return qe((w(), U(S, { modelValue: b.value, "onUpdate:modelValue": g[0] || (g[0] = (h) => b.value = h), options: e.options, type: e.type, unshowVal: E.value, disabledVal: e.disabledVal, showOptionAll: e.showOptionAll, default: c.default, onChange: V }, { suffix: p(({ item: h }) => [xt(M.$slots, "suffix", { item: h })]), _: 3 }, 8, ["modelValue", "options", "type", "unshowVal", "disabledVal", "showOptionAll", "default"])), [[ln, !y.value]]);
  };
} };
const clt = { class: "pagination-box-container el-pagination" }, dlt = { __name: "my-pagination", props: { requestData: { type: Object, required: true }, total: { type: [Number, String], required: true } }, emits: ["handleChange"], setup(e, { emit: o }) {
  const n = e, c = o, u = Z(n.requestData), r = (y) => {
    u.value.pageNumber = y, c("handleChange");
  }, E = (y) => {
    u.value.pageSize = y, c("handleChange");
  };
  return (y, b) => {
    const V = Fn;
    return w(), Q("div", clt, [s(V, { "current-page": n.requestData.pageNumber, "page-size": n.requestData.pageSize, "page-sizes": [10, 20, 30, 40, 50, 100], total: n.total, layout: "total, prev, pager, next, sizes", onSizeChange: E, onCurrentChange: r }, null, 8, ["current-page", "page-size", "total"])]);
  };
} }, mlt = ut(dlt, [["__scopeId", "data-v-d5291fe8"]]);
function plt(e, o, n, c = "tableList", u) {
  if (n) {
    if (e === "deep") {
      const r = Ct({});
      Ce(o, () => {
        for (const M in r) r[M] = false;
      });
      const E = [], y = Dt(() => {
        E.forEach((M) => M()), E.length = 0, n.tableList.forEach((M, g) => {
          n.tableList[g] && Object.keys(M).forEach((S) => {
            const h = Ce(() => n.tableList[g] && n.tableList[g][S], async () => {
              n.tableList[g] && o.value.validateField(`tableList.${g}.${S}`, (T) => {
                r[`tableList.${g}.${S}`] = !T;
              });
            });
            E.push(h);
          });
        });
      });
      return u && typeof u == "function" && u(() => y()), { errorFields: r, save: (M) => {
        console.log(o.value), o.value.validate((g, S) => {
          if (g) return true;
          if (S) if (g) {
            for (const h in r) r[h] = false;
            M();
          } else for (const h in S) S[h] && (r[h] = true);
        });
      }, handleBlur: (M) => {
        o.value.validateField(M, (g) => {
          r[M] = !g;
        });
      } };
    } else if (e === "shallow") {
      const r = Ct({}), E = () => new Promise((V, M) => {
        if (o.value.tagName === "DIV") return null;
        o.value.validate((g, S) => {
          if (g && V(), !!S) {
            if (g) for (const h in S) r[h] = false, V();
            else for (const h in S) r[h] = true;
            return M("校验失败");
          }
        });
      });
      El(() => {
        Object.keys(n).length && Object.keys(n).forEach((V) => {
          Ce(() => n[V], async (M, g) => {
            o.value && o.value.tagName !== "DIV" && M !== g && await o.value.validateField(V, (S, h) => {
              r[V] = !S;
            });
          });
        });
      });
      const y = JSON.parse(JSON.stringify(n)), b = async (V) => {
        n[V] !== y[V] && o.value.validateField(V, (M) => {
          r[V] = !M;
        });
      };
      return Ce(o, () => {
        for (const V in r) r[V] = false;
      }), { save: E, errorFields: r, handleBlur: b };
    }
  } else return { errorFields: Ct({}) };
}
const hlt = { key: 0, class: "checkbox-container" }, flt = { __name: "Descriptions-List", props: { isFrom: { type: Boolean, default: false }, tableList: { type: [Array, void 0], required: true }, column: { type: [Number, String], required: true }, size: { type: String, default: "default" }, formData: { type: Object, default: () => {
} }, formRules: { type: Object, default: () => {
} }, direction: { type: String, default: "horizontal" }, labelWidth: { type: String, default: "130px" }, itemWidth: { type: String, default: "15vw" }, hiddenItem: { type: Array, default: () => [] } }, setup(e) {
  const o = e, n = Ee(() => {
    var S;
    return (S = o.hiddenItem) != null && S.length ? o.tableList.filter((h) => !o.hiddenItem.includes(h.key)) : o.tableList;
  }), c = Ee(() => A(o.formRules) ? o.formRules : Rpe(n.value)), u = Z(null), r = ft("validateList", []), E = ft("formRefList", []), y = ft("saveList", false), { errorFields: b = {}, save: V = {} } = plt("shallow", u, o.formData);
  WM(() => {
    var T;
    const S = o.formRules ? () => u.value.validate() : void 0;
    S && r && r.value && r.value.push(S), o.formData && ((T = Object.keys(c.value)) == null ? void 0 : T.length) > 0 && y && typeof V == "function" && y.value.push(V);
    const h = c.value ? u : void 0;
    h && E && E.value && E.value.push(h.value);
  }), bl(() => {
    y != null && y.value && y.value.splice(0);
  });
  function M(S) {
    return o.formData ? o.formData[S.key] : S;
  }
  function g() {
    var S, h;
    return o.formRules || c.value ? ((S = Object.keys(o.formRules)) == null ? void 0 : S.length) > 0 || ((h = Object.keys(c.value)) == null ? void 0 : h.length) > 0 : false;
  }
  return (S, h) => {
    const T = Mt, _ = Zi, f = qa, m = Ga, R = _t("ellipsis");
    return w(), U(Ri(g ? "el-form" : "div"), { ref_key: "formRef", ref: u, model: o.formData, rules: c.value, style: ri(`--label-width:${o.labelWidth};--item-width:${o.itemWidth};--label-column:${o.column}`) }, { default: p(() => [s(m, { column: o.column, direction: o.direction, size: o.size, border: "", class: "margin-top" }, { default: p(() => [(w(true), Q(Qe, null, ki(n.value, (v) => (w(), U(f, { key: v.key, align: "left", "class-name": "description-item", "label-class-name": "label-class-item" }, { label: p(() => [v.labelSlot ? (w(), Q("span", hlt, [xt(S.$slots, v.label_key, { label: v.label }, void 0, true)])) : (w(), Q("span", { key: 1, class: Zt(v.verify ? "prop-span" : ""), style: { "font-size": "14px" } }, K(v.label), 3))]), default: p(() => [S.$slots[v.key] ? (w(), Q(Qe, { key: 1 }, [v.verify && c.value ? (w(), U(_, { key: v.key, class: Zt({ "error-placeholder": Object.keys(l(b)).length > 0 && l(b)[v.key] }), prop: v.key }, { default: p(() => [xt(S.$slots, v.key, { item: v.key in c.value ? v.key : "" }, void 0, true)]), _: 2 }, 1032, ["class", "prop"])) : xt(S.$slots, v.key, { key: 1, item: v.key, label: v.label, val: v.value, value: M(v) }, void 0, true)], 64)) : (w(), Q(Qe, { key: 0 }, [v.value ? qe((w(), Q("span", { key: 1, style: ri({ color: v == null ? void 0 : v.vColor }), class: "notSlotValue" }, [Te(K(v.value), 1)], 4)), [[R]]) : (w(), U(T, { key: 0, placeholder: v.label, style: ri({ color: v == null ? void 0 : v.vColor }), readonly: "" }, null, 8, ["placeholder", "style"]))], 64))]), _: 2 }, 1024))), 128))]), _: 3 }, 8, ["column", "direction", "size"])]), _: 3 }, 8, ["model", "rules", "style"]);
  };
} }, glt = ut(flt, [["__scopeId", "data-v-ce3bfec4"]]);
const Elt = { class: "common-label" }, ylt = { __name: "index", props: { label: { type: String, required: true }, width: { type: Number, default: 210 }, labelWidth: { type: Number, default: void 0 }, size: { type: String, default: "large" } }, setup(e) {
  const o = e;
  return (n, c) => {
    const u = wi;
    return w(), Q("span", Elt, [C("span", { style: ri({ width: o.width + "px" }) }, [s(u, { "disable-transitions": true, size: o.size, style: ri({ width: o.labelWidth + "px" }), type: "info" }, { default: p(() => [Te(K(o.label), 1)]), _: 1 }, 8, ["size", "style"]), C("span", null, [xt(n.$slots, "default", { size: o.size }, void 0, true)])], 4)]);
  };
} }, Tlt = ut(ylt, [["__scopeId", "data-v-5406586d"]]), _lt = /* @__PURE__ */ new Map([["commonInputNumber", Cye], ["commonButton", Pye], ["commonTipButton", xye], ["commonSelect", zye], ["commonSelectV2", qye], ["commonRadio", Gye], ["commonRadioButton", Qye], ["commonTable", Zye], ["commonDrawer", a0e], ["commonDialog", c0e], ["projectRadioButton", d0e], ["printTable", olt], ["tableCellTag", g_], ["projectCascader", rlt], ["componentRadioButton", ult], ["tableHeader", $8], ["myPagination", mlt], ["DescriptionsList", glt], ["commonLabel", Tlt]]), blt = (e) => {
  _lt.forEach((o, n) => {
    e.component(n, o);
  });
}, Vlt = { mounted(e, o) {
  wlt(e, o);
} };
function wlt(e, o) {
  const { value: n } = o;
  if (Ai(n)) return true;
  e.parentNode && e.parentNode.removeChild(e);
}
const Slt = { mounted(e, o) {
  cV(e, o);
}, updated(e, o) {
  cV(e, o);
} };
function cV(e, o) {
  const { value: n } = o;
  if (n !== null && typeof n == "object") {
    const { val: c, fmt: u = "{y}-{m}-{d} {h}:{i}" } = n;
    e.innerText = Qi(c, u);
  } else e.innerText = Qi(n, "{y}-{m}-{d} {h}:{i}");
}
const vlt = { mounted(e, o) {
  dV(e, o);
}, updated(e, o) {
  dV(e, o);
} };
function dV(e, o) {
  const { value: { e: n, v: c, f: u = "L", bit: r = false, split: E = "、", emptyText: y, extra: b = "" } } = o;
  if (e.innerText = "", Ae(c)) return;
  let V = n.V;
  if (Ae(V) && (V = {}, Object.keys(n).forEach((S) => {
    const h = n[S].V;
    V[h] = n[S];
  })), Ae(V)) return;
  let M;
  Array.isArray(c) ? M = c.map((g) => V[g][u]).join(E) : r ? M = qm(Ra.getBits(n, c, u)).join(E) : M = V[c][u] || "", M && (M += b, e.innerText = y ? Si(M, y) : M);
}
const Rlt = { mounted(e, o) {
  mV(e, o);
}, updated(e, o) {
  mV(e, o);
} };
function mV(e, o) {
  const { value: { project: n, split: c = "、", onlyShortName: u = false } } = o;
  if (Ae(n)) return;
  let r = [];
  Array.isArray(n) ? r = n : r = [n], u ? e.innerText = r.map((E) => E.shortName).join(c) : e.innerText = r.map((E) => di(E, null, false)).join(c);
}
const Mlt = { mounted(e, o) {
  pV(e, o);
}, updated(e, o) {
  pV(e, o);
} };
function pV(e, o) {
  const { value: n } = o, { innerText: c } = e;
  if (n !== null && typeof n == "object") {
    const { val: u, blank: r = "-" } = n;
    e.innerText = Si(u, r);
  } else e.innerText = Si(n || c, "-");
}
const Alt = { mounted(e, o) {
  hV(e, o);
}, updated(e, o) {
  hV(e, o);
} };
function hV(e, o) {
  const { value: n } = o, { innerText: c } = e;
  if (n !== null && typeof n == "object") {
    const { val: u, blank: r = "-" } = n;
    e.innerText = Si(u, r);
  } else e.innerText = Si(n || c, "-");
}
const Nlt = { mounted(e, o) {
  fV(e, o);
}, updated(e, o) {
  fV(e, o);
} };
function fV(e, o) {
  const { value: n } = o, { innerText: c } = e;
  c && (e.innerText = iw(c, n));
}
const Llt = { mounted(e, o) {
  gV(e, o);
}, updated(e, o) {
  gV(e, o);
} };
function gV(e, o) {
  const { value: n } = o, { innerText: c } = e;
  c && (e.innerText = aw(c, n));
}
const Ilt = { mounted(e, o) {
  EV(e, o);
}, updated(e, o) {
  EV(e, o);
} };
function EV(e, o) {
  const { value: n } = o;
  let c, u;
  if (Array.isArray(n) ? c = n : n && typeof n == "object" ? (c = n.val, u = n.symbol) : c = n, !Array.isArray(c)) {
    e.innerText = c;
    return;
  }
  u = u || "、", e.innerText = c.join(u);
}
const Clt = { mounted(e, o) {
  yV(e, o);
}, updated(e, o) {
  yV(e, o);
} };
function yV(e, o) {
  const { value: n } = o, { innerText: c } = e;
  let u, r, E;
  n && typeof n == "object" ? (u = n.val, r = n.dp, E = Ze[n.k]) : (u = c, r = n), r = A(r) ? r : A(E) ? E : 2, e.innerText = ji(u, r);
}
const Plt = { mounted(e, o) {
  TV(e, o);
}, updated(e, o) {
  TV(e, o);
} };
function TV(e, o) {
  const { value: n } = o;
  let c, u;
  n && typeof n == "object" ? (c = n.val, u = n.dp) : c = n, u = A(u) ? u : 2, e.innerText = Mi(c, u);
}
const Olt = { mounted(e, o) {
  klt(e, o);
} };
function klt(e, o) {
  const { value: { unit: n = "kg", dp: c = 2 } = {} } = o, { innerText: u } = e;
  e.innerText = St(u, Ft.WEIGHT, n, c, { toNum: false });
}
const Dlt = { mounted(e, o) {
  xlt(e);
} };
function xlt(e, o) {
  e.tagName.toLocaleUpperCase() !== "INPUT" && (e = e.getElementsByTagName("input")[0]), e.onblur = (n) => {
    e.value = Mi(e.value);
  };
}
let ms;
const Ult = { mounted(e, o) {
  _V(e, o);
}, updated(e, o) {
  _V(e, o);
}, unmounted() {
  xm();
} };
function _V(e, o) {
  e.removeEventListener("mouseenter", bV), e.removeEventListener("mouseleave", xm), o.value !== false && (e.style.overflow = "hidden", e.style.textOverflow = "ellipsis", e.style.whiteSpace = "nowrap", e.style.display = "inline-block", e.style.width = "100%", requestAnimationFrame(() => {
    e.innerText && Ylt(e.innerText) > e.offsetWidth - 20 && (e.addEventListener("mouseenter", bV), e.addEventListener("mouseleave", xm));
  }));
}
const Ylt = (e) => {
  const o = document.createElement("span");
  o.textContent = e, o.style.whiteSpace = "nowrap", o.style.visibility = "hidden", document.body.appendChild(o);
  const n = o.offsetWidth;
  return document.body.removeChild(o), n;
};
function bV(e) {
  ms || (ms = document.createElement("div"), document.body.appendChild(ms));
  const o = 600;
  let n = `
          max-width: ${o}px;
          overflow: auto;
          position: fixed;
          background: #262627;
          color: #fff;
          border-radius: 4px;
          line-height: 20px;
          padding: 10px;
          display: block;
          font-size: 12px;
          z-index: 999999;
          word-break: break-all;
        `;
  window.innerWidth - e.clientX < o ? n += `right:${window.innerWidth - e.clientX}px;` : n += `left:${e.clientX + 20}px;`, window.innerHeight - e.clientY < 600 ? n += `bottom:${window.innerHeight - e.clientY}px;` : n += `top:${e.clientY}px;`, ms.style.cssText = n, ms.innerHTML = e.currentTarget.innerText;
}
function xm() {
  ms && (ms.style.display = "none");
}
const Xd = /* @__PURE__ */ new WeakMap(), Klt = { mounted: (e, o) => {
  const n = e.querySelector("input");
  if (n) {
    const c = () => {
      n.value ? (n.style.backgroundColor = "", n.classList.remove("red-placeholder")) : (n.style.backgroundColor = "rgba(255, 0, 0, 0.1)", n.classList.add("red-placeholder"));
    };
    Xd.set(e, c), n.addEventListener("input", c), c();
  }
}, unmounted: (e) => {
  const o = e.querySelector("input"), n = Xd.get(e);
  o && n && (o.removeEventListener("input", n), Xd.delete(e));
} }, Wlt = /* @__PURE__ */ new Map([["permission", Vlt], ["parse-time", Slt], ["parse-enum", vlt], ["parse-project", Rlt], ["empty-text", Mlt], ["empty", Alt], ["prefix", Nlt], ["suffix", Llt], ["split", Ilt], ["to-fixed", Clt], ["thousand", Plt], ["convert-weight", Olt], ["show-thousand", Dlt], ["ellipsis", Ult], ["empty-bgc", Klt]]), jlt = (e) => {
  Wlt.forEach((o, n) => {
    e.directive(n, o);
  });
};
jM.setLanguage("zh-CN");
function Flt(e) {
  e.use(FM), e.use(zM), e.use(BM), e.use(HM), e.use(qM), e.use(GM), e.use(QM), e.use(ZM), e.use(JM), e.use(XM), e.use($M), e.use(eA), e.use(tA);
}
function zlt(e) {
  e.use(iA), e.use(aA), e.use(lA), e.use(oA), e.use(nA);
}
